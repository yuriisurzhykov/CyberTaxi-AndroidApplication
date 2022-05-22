package com.cybertaxi.uicomponents.codeinpnut

import android.animation.Animator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.*
import android.text.InputFilter
import android.text.InputType
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.annotation.IntRange
import androidx.appcompat.widget.AppCompatEditText
import com.cybertaxi.uicomponents.R
import kotlin.math.abs

/**
 * @attr codeEntryCount - Indicates the number of digits to enter(by default [DEFAULT_PIN_COUNT])
 * @attr cellColors - Indicates the digits background color(rect color)
 * @attr outlineColors - Specific colors for outline drawable for background
 * @attr outlineStrokeWidth - Indicates width of outline of background
 * @attr errorColor - Color for error state(by default is [Color.RED]
 * @attr resetErrorOnChangeText - Indicates that need to reset error state after user change text
 */
class CodeInputEditText : AppCompatEditText {
    private val density = context.resources.displayMetrics.density
    private var pinCount: Int = DEFAULT_PIN_COUNT
    private var strokeWidth: Float = DEFAULT_STROKE_WIDTH
    private var smallStrokeWidth: Float = SMALL_STROKE_WIDTH

    private var animationDuration: Int = DEFAULT_ANIMATION_DURATION
    private var cursorFadeAnimationDuration: Long = 700

    private var mPinSpace: Float = 2f
    private var mCharSize: Float = 0f
    private var mCharsRectCoordinates: ArrayList<RectF> = ArrayList()
    private var mCharsBottomCoordinates: ArrayList<Float> = ArrayList()
    private var mCharPaint: Paint? = null
    private var mLastCharPaint: Paint? = null
    private var mEmptyRectPaint: Paint? = null
    private var mOutlineRectPaint: Paint? = null
    private var mCursorPaint: Paint? = null

    private var cornerRadius: Float = 8f * density
    private var minCharPadding = 2f * density
    private var cursorVerticalPadding = 10f * density

    private var mStates = arrayOf(
        intArrayOf(android.R.attr.state_selected),
        intArrayOf(android.R.attr.state_focused),
        intArrayOf(-android.R.attr.state_focused)
    )

    private var mColors = intArrayOf(
        Color.GRAY,
        Color.BLACK,
        Color.GRAY
    )

    private var mColorsOutline = intArrayOf(
        Color.DKGRAY,
        Color.BLUE,
        Color.GRAY
    )

    private var mColorStates = ColorStateList(mStates, mColors)
    private var mRectOutlineStates = ColorStateList(mStates, mColorsOutline)
    private var errorColor = Color.RED

    var onPinEnteredListener: OnCodeEnteredListener? = null
    private var isErrorState = false
    private var enableResetErrorStateOnTextChange = true

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initWithParams(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initWithParams(context, attrs)
    }

    private fun initWithParams(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.CodeInputEditText,
            0,
            0
        ).apply {
            pinCount = getColor(R.styleable.CodeInputEditText_codeEntryCount, DEFAULT_PIN_COUNT)
            val colors = getColorStateList(R.styleable.CodeInputEditText_cellColors)
            if (colors != null) {
                mColorStates = colors
            }
            val outlineColors = getColorStateList(R.styleable.CodeInputEditText_outlineColors)
            if (outlineColors != null) {
                mRectOutlineStates = outlineColors
            }
            strokeWidth =
                getDimension(R.styleable.CodeInputEditText_outlineStrokeWidth, DEFAULT_STROKE_WIDTH)
            errorColor = getColor(R.styleable.CodeInputEditText_errorColor, Color.RED)
            enableResetErrorStateOnTextChange =
                getBoolean(R.styleable.CodeInputEditText_resetErrorOnChangeText, true)
            recycle()
        }
        includeFontPadding = false
        filters = arrayOf(InputFilter.LengthFilter(pinCount))
        inputType = InputType.TYPE_NUMBER_VARIATION_NORMAL or InputType.TYPE_CLASS_NUMBER
        mPinSpace *= density
        mCharPaint = Paint(paint).apply {
            color = textColors.defaultColor
        }
        mLastCharPaint = Paint(paint)
        mEmptyRectPaint = Paint(paint).apply {
            style = Paint.Style.FILL
            strokeWidth = smallStrokeWidth
        }
        mOutlineRectPaint = Paint(paint).apply {
            style = Paint.Style.STROKE
            color = mRectOutlineStates.defaultColor
            strokeWidth = this@CodeInputEditText.strokeWidth
        }
        mCursorPaint = Paint(paint).apply {
            style = Paint.Style.FILL
            color = getColorOutlineForState(android.R.attr.state_selected)
            strokeWidth = this@CodeInputEditText.strokeWidth
        }
        background = null
        isCursorVisible = false
        setTextIsSelectable(false)
    }

    /**
     * @param isError Indicates that error state is need to be shown or hidden.
     */
    fun drawError(isError: Boolean) {
        if (isError && enableResetErrorStateOnTextChange) {
            text = null
            clearFocus()
        }
        isErrorState = isError
        invalidate()
    }

    /**
     * Sets up digits count in runtime.
     * @param count New count of cell inputs for code. Should be greater than 0.
     */
    fun setEntryCount(@IntRange(from = 1) count: Int) {
        if (count > 0 && count != pinCount) {
            pinCount = count
            filters = arrayOf(InputFilter.LengthFilter(pinCount))
            invalidate()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        textColors?.let { originalColors ->
            mLastCharPaint!!.color = originalColors.defaultColor
            mCharPaint!!.color = originalColors.defaultColor
        }
        mCharsRectCoordinates.clear()
        mCharsBottomCoordinates.clear()
        val availableWidth = width - paddingStart - paddingEnd
        val pinCountWidth = height * pinCount
        val availablePadding: Int
        if (pinCountWidth <= availableWidth) {
            availablePadding = (availableWidth - pinCountWidth) / pinCount
            mCharSize = (height).toFloat()
            mPinSpace = availablePadding.toFloat()
        } else {
            availablePadding = minCharPadding.toInt()
            mPinSpace = minCharPadding
            mCharSize = (availableWidth - minCharPadding * pinCount) / pinCount
        }
        var startX = (paddingStart + (availablePadding / 2)).toFloat()
        repeat(pinCount) {
            mCharsRectCoordinates.add(
                RectF(
                    startX,
                    strokeWidth,
                    startX + mCharSize,
                    height.toFloat() - strokeWidth
                )
            )
            startX += mCharSize + mPinSpace
        }
        repeat(pinCount) {
            val metrics = paint.fontMetricsInt
            val fontHeight = abs(metrics.ascent - metrics.descent)
            val baselineBottomPadding = abs(metrics.bottom - metrics.leading)
            mCharsBottomCoordinates.add(height - ((height - fontHeight) / 2).toFloat() - baselineBottomPadding)
        }
        animateCursorPaint()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val text = this.text.toString()
        val textLength = text.length
        val textWidths = FloatArray(textLength)
        paint.getTextWidths(text, 0, textLength, textWidths)
        repeat(pinCount) { index ->
            updateColorForLines(index == textLength)
            canvas.drawRoundRect(
                mCharsRectCoordinates[index],
                cornerRadius,
                cornerRadius,
                mEmptyRectPaint!!
            )
            canvas.drawRoundRect(
                mCharsRectCoordinates[index],
                cornerRadius,
                cornerRadius,
                mOutlineRectPaint!!
            )
            if (index == textLength && isFocused) {
                drawCursorPointer(canvas, mCharsRectCoordinates[index])
            }
        }
        repeat(pinCount) { index ->
            val middle: Float = mCharsRectCoordinates[index].left + mCharSize / 2
            if (textLength > index) {
                val paint = if (index != textLength - 1) {
                    mCharPaint!!
                } else {
                    mLastCharPaint!!
                }
                val x = middle - textWidths[index] / 2
                val y = mCharsBottomCoordinates[index]
                canvas.drawText(text, index, index + 1, x, y, paint)
            }
        }
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if (focused && isErrorState && enableResetErrorStateOnTextChange) {
            isErrorState = false
        }
    }

    private fun updateColorForLines(hasTextOrIsNext: Boolean) {
        if (isErrorState) {
            mEmptyRectPaint?.color = errorColor
            mOutlineRectPaint?.color = errorColor
        } else if (isFocused) {
            mEmptyRectPaint?.color = getColorForState(android.R.attr.state_focused)
            mOutlineRectPaint?.color = getColorOutlineForState(android.R.attr.state_focused)
            if (hasTextOrIsNext) {
                mEmptyRectPaint?.color = getColorForState(android.R.attr.state_selected)
                mOutlineRectPaint?.color = getColorOutlineForState(android.R.attr.state_selected)
            }
        } else {
            mEmptyRectPaint?.color = getColorForState(-android.R.attr.state_focused)
            mOutlineRectPaint?.color = getColorForState(-android.R.attr.state_focused)
        }
    }

    private fun getColorForState(vararg states: Int): Int {
        return mColorStates.getColorForState(states, Color.GRAY)
    }

    private fun getColorOutlineForState(vararg states: Int): Int {
        return mRectOutlineStates.getColorForState(states, Color.DKGRAY)
    }

    private fun drawCursorPointer(canvas: Canvas, rect: RectF) {
        val startX = rect.left + (rect.right - rect.left) / 2 - strokeWidth / 2
        val startY = rect.top + cursorVerticalPadding
        val endY = rect.bottom - cursorVerticalPadding
        canvas.drawLine(startX, startY, startX, endY, mCursorPaint!!)
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (lengthAfter > lengthBefore) {
            animatePopIn()
        }
        if (enableResetErrorStateOnTextChange) {
            drawError(false)
        }
    }

    private fun animatePopIn() {
        val va = ValueAnimator.ofFloat(1f, paint.textSize)
        va.duration = animationDuration.toLong()
        va.interpolator = OvershootInterpolator()
        va.addUpdateListener { animation ->
            mLastCharPaint?.textSize = animation.animatedValue as Float
            this@CodeInputEditText.invalidate()
        }
        if (text!!.length == pinCount && onPinEnteredListener != null) {
            va.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    onPinEnteredListener?.onPinEntered(text.toString())
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
        }
        va.start()
    }

    private fun animateCursorPaint() {
        val animator = ValueAnimator.ofInt(0, 255)
        animator.duration = cursorFadeAnimationDuration
        animator.repeatCount = Animation.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        animator.interpolator = BounceInterpolator()
        animator.addUpdateListener { animation ->
            mCursorPaint?.alpha = animation.animatedValue as Int
            invalidate()
        }
        animator.start()
    }

    fun interface OnCodeEnteredListener {
        fun onPinEntered(pin: String)
    }

    companion object {
        private const val DEFAULT_PIN_COUNT: Int = 4
        private const val DEFAULT_STROKE_WIDTH: Float = 2.5f
        private const val DEFAULT_ANIMATION_DURATION: Int = 200
        private const val SMALL_STROKE_WIDTH = 2f
    }
}
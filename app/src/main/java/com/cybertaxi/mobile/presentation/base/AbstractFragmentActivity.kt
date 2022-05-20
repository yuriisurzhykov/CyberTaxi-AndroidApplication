package com.cybertaxi.mobile.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.cybertaxi.mobile.R

abstract class AbstractFragmentActivity : AppCompatActivity(), IFragmentActivity {

    protected open val layoutRes: Int = R.layout.activity_container
    protected open val contentContainerId: Int = R.id.content_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun showFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(contentContainerId, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    override fun showDialogFragment(dialogFragment: DialogFragment, tag: String) {
        dialogFragment.show(supportFragmentManager, tag)
    }
}
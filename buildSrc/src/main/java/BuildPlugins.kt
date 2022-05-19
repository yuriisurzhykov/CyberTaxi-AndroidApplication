object BuildPlugins {

    object Configs {
        val kotlin by lazy { "1.5.31" }
        val buildToolsVersion by lazy { "7.0.0" }
    }

    val androidGradlePlugin by lazy { "com.android.tools.build:gradle:${Configs.buildToolsVersion}" }
    val kotlinGradlePlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Configs.kotlin}" }
    val androidApplication by lazy { "com.android.application" }
    val kotlinAndroid by lazy { "kotlin-android" }
    val kotlinAndroidExtensions by lazy { "kotlin-android-extensions" }

}
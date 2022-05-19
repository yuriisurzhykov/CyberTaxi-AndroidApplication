object Testing {

    private object Version {
        val room by lazy { Versions.room }
        val espresso by lazy { "3.4.0" }
        val junitAndroid by lazy { "1.1.3" }
        val core by lazy { "1.4.0" }
        val junit by lazy { "4.12" }
    }

    object Android {
        val room by lazy { "androidx.room:room-testing:${Version.room}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Version.espresso}" }
        val junitCore by lazy { "androidx.test.ext:junit:${Version.junitAndroid}" }
        val core by lazy { "androidx.test:core:${Version.core}" }
    }

    object Unit {
        val junit by lazy { "junit:junit:${Version.junit}" }
    }
}
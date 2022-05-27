object Deps {

    object Core {
        val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
        val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
        val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
        val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    }

    object Domain {
        val lifecycle by lazy { "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}" }
        val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}" }
        val room by lazy { "androidx.room:room-runtime:${Versions.room}" }
        val roomExtensions by lazy { "androidx.room:room-ktx:${Versions.room}" }
        val workManager by lazy { "androidx.work:work-runtime-ktx:${Versions.workManager}" }
        val preferences by lazy { "androidx.preference:preference-ktx:${Versions.preferences}" }
        val kotlinSerialization by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}" }
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
        val okio by lazy { "com.squareup.okio:okio:${Versions.okio}" }
        val gson by lazy { "com.google.code.gson:gson:${Versions.retrofit}" }
    }

    object UI {
        val material by lazy { "com.google.android.material:material:${Versions.material}" }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
        val fragments by lazy { "androidx.fragment:fragment-ktx:${Versions.fragments}" }
        val activities by lazy { "androidx.activity:activity-ktx:${Versions.activities}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
        val constraintLayoutCompose by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
        val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    }


    object GMS {
        val analytics by lazy { "com.google.firebase:firebase-analytics" }
        val firestore by lazy { "com.google.firebase:firebase-firestore-ktx" }
    }

    object DI {
        val dagger by lazy { "com.google.dagger:dagger:${Versions.dagger}" }
        val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    }
}
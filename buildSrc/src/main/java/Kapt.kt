object Kapt {
    val lifecycle by lazy { "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}" }
    val room by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val dagger by lazy { "com.google.dagger:dagger-compiler:${Versions.dagger}" }
    val daggerProcessor by lazy { "com.google.dagger:dagger-android-processor:${Versions.dagger}" }
    val hilt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
}
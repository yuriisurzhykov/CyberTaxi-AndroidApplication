object ProjectDepsProvider : DependenciesProvider {
    override fun dependenciesList(): List<String> {
        return arrayListOf(
            Deps.SDK.androidCore,
            Deps.SDK.kotlin,
            Deps.Domain.lifecycle,
            Deps.Domain.kotlinSerialization,
            Deps.Domain.retrofit,
            Deps.Domain.room,
            Deps.Domain.roomExtensions,
            Deps.Domain.workManager,
            Deps.Domain.okio,
            Deps.UI.fragments,
            Deps.UI.activities,
            Deps.DI.dagger,
            Deps.UI.material,
            Deps.UI.appCompat,
            Deps.UI.constraintLayout
        )
    }
}

object ProjectTestDepsProvider : DependenciesProvider {
    override fun dependenciesList(): List<String> {
        return arrayListOf(
            Testing.Unit.junit
        )
    }
}

object ProjectKaptProvider : DependenciesProvider {
    override fun dependenciesList(): List<String> {
        return arrayListOf(
            Kapt.room,
            Kapt.dagger,
            Kapt.lifecycle
        )
    }
}

object ProjectAndroidTestDepsProvider : DependenciesProvider {
    override fun dependenciesList(): List<String> {
        return arrayListOf(
            Testing.Android.room,
            Testing.Android.core,
            Testing.Android.espressoCore,
            Testing.Android.junitCore
        )
    }
}

object ProjectPlatformDepsProvider : DependenciesProvider {
    override fun dependenciesList(): List<String> {
        return arrayListOf(Platform.googleBoom)
    }
}
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun interface DependenciesProvider {
    fun dependenciesList(): List<String>
}

fun DependencyHandler.kapt(provider: DependenciesProvider) {
    absImplementation("kapt", provider)
}

fun DependencyHandler.implementation(provider: DependenciesProvider) {
    absImplementation("implementation", provider)
}

fun DependencyHandler.platformImplementation(provider: DependenciesProvider) {
    provider.dependenciesList().forEach { dependency ->
        add("implementation", platform(dependency))
    }
}

fun DependencyHandler.projectImplementation(provider: DependenciesProvider) {
    provider.dependenciesList().forEach { dependency ->
        add("implementation", project(dependency))
    }
}

fun DependencyHandler.projectImplementation(dependency: String) {
    add("implementation", project(dependency))
}

fun DependencyHandler.androidTestImplementation(provider: DependenciesProvider) {
    absImplementation("androidTestImplementation", provider)
}

fun DependencyHandler.testImplementation(provider: DependenciesProvider) {
    absImplementation("testImplementation", provider)
}

fun DependencyHandler.apiImplementation(provider: DependenciesProvider) {
    absImplementation("api", provider)
}

private fun DependencyHandler.absImplementation(
    configuration: String,
    provider: DependenciesProvider
) {
    provider.dependenciesList().forEach { dependency ->
        add(configuration, dependency)
    }
}
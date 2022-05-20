object Configs {
    const val compileSdkVersion = 31
    const val buildToolsVersion = "31.0.0"
    const val minSdkVersion = 26
    const val targetSdkVersion = 31
    const val versionName = "1.0"
    val versionCode = getVersionCode()
}

fun getVersionCode(): Int {
    return try {
        System.getProperty("BUILD_VERSION").toInt()
    } catch (e: NumberFormatException) {
        return 1
    } catch (e: NullPointerException) {
        return 1
    }
}
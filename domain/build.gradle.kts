plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(ProjectProperties.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(ProjectProperties.MIN_SDK)
        targetSdkVersion(ProjectProperties.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(project(":data"))

    /*Kotlin*/
    api(Lib.Kotlin.KT_STD)
    api(Lib.Async.COROUTINES)

    /* Dependency Injection */
    api(Lib.Di.DAGGER)
    kapt(Lib.Di.DAGGER_PROCESSOR)
    kapt(Lib.Di.DAGGER_COMPILER)

    /* Firebase Sign In */
    implementation(Lib.Firebase.FIREBASE_LOGIN)

    /* Coroutines Play Service */
    implementation(Lib.CoroutinesPlayService.COROUTINES_PLAY_SERVICE)

    /* Testing */
    testImplementation(TestLib.MOCKK)
    androidTestImplementation(TestLib.JUNIT)
    androidTestImplementation(TestLib.CORE_TEST)
    androidTestImplementation(TestLib.ANDROID_JUNIT)
    androidTestImplementation(TestLib.MOCK_WEB_SERVER)
    androidTestImplementation(TestLib.ROBO_ELECTRIC)
    androidTestImplementation(TestLib.COROUTINES)
    androidTestImplementation(TestLib.MOCKK)
    androidTestImplementation(TestLib.ANDROID_JUNIT_KTX)
    androidTestImplementation(TestLib.ESPRESSOO)
}
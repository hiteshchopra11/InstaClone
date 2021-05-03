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
        buildConfigField(
            "String",
            "SEARCH_API_KEY",
            "\"Sa9aP1DcSz-H54LAn6S1kvySZuNmgLEVywSUtUe0LDA\""
        )
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    /*Kotlin*/
    api(Lib.Kotlin.KT_STD)
    api(Lib.Async.COROUTINES)

    /* Networking */
    api(Lib.Networking.RETROFIT)
    api(Lib.Networking.RETROFIT_GSON)
    api(Lib.Networking.LOGGING)

    api(Lib.Serialization.GSON)

    /* Dependency Injection */
    api(Lib.Di.DAGGER)
    implementation("androidx.sqlite:sqlite-ktx:2.1.0")
    kapt(Lib.Di.DAGGER_PROCESSOR)
    kapt(Lib.Di.DAGGER_COMPILER)

    /* Room */
    implementation("androidx.room:room-runtime:2.4.0-alpha01")
    kapt("androidx.room:room-compiler:2.4.0-alpha01")
    implementation("androidx.room:room-ktx:2.4.0-alpha01")

    /* Firebase Sign In */
    implementation(Lib.Firebase.FIREBASE_LOGIN)

    /* Coroutines Play Service */
    implementation(Lib.CoroutinesPlayService.COROUTINES_PLAY_SERVICE)

    /* Testing */
    testImplementation(TestLib.MOCKK)
    testImplementation(TestLib.TRUTH)
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
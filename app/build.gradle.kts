plugins {
    id(BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_PARCELABLE_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.GOOGLE_GRADLE_SERVICES)
    id(BuildPlugins.SAFE_ARGS_PLUGIN)
    id("org.jlleitschuh.gradle.ktlint")
}

subprojects {
    apply {
        from("variants.gradle.kts")
    }
}


android {
    compileSdkVersion(ProjectProperties.COMPILE_SDK)

    defaultConfig {
        applicationId = (ProjectProperties.APPLICATION_ID)
        minSdkVersion(ProjectProperties.MIN_SDK)
        targetSdkVersion(ProjectProperties.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    packagingOptions {
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
        exclude("LICENSE.txt")
    }

    dexOptions {
        preDexLibraries = true
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Gradle automatically adds 'android.test.runner' as a dependency.
    useLibrary("android.test.runner")
    useLibrary("android.test.base")
    useLibrary("android.test.mock")
}

// Required for annotation processing plugins like Dagger
kapt {
    generateStubs = true
    correctErrorTypes = true
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    /* Kotlin */
    api(Lib.Kotlin.KT_STD)
    api(Lib.Kotlin.KTX_CORE)

    /* Android Designing and layout */
    implementation(Lib.Android.CONSTRAINT_LAYOUT)
    implementation(Lib.Android.FRAGMENT)
    implementation(Lib.Android.MATERIAL_DESIGN)
    implementation(Lib.Android.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Lib.Android.APPCOMPAT)

    /* DI */
    implementation(Lib.Di.DAGGER)
    implementation(Lib.Di.DAGGER_ANDROID)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0")
    implementation("androidx.room:room-runtime:2.2.6")
    annotationProcessor("androidx.room:room-compiler:2.2.6")
    kapt(Lib.Di.DAGGER_PROCESSOR)
    kapt(Lib.Di.DAGGER_COMPILER)
    kaptTest(Lib.Di.DAGGER_COMPILER)

    /* Logger */
    api(Lib.Logger.TIMBER)

    /* Async */
    api(Lib.Async.COROUTINES)
    api(Lib.Async.COROUTINES_ANDROID)

    /* Glide */
    implementation(Lib.ImageLibrary.GLIDE)

    /* Navigation Component */
    implementation(Lib.Navigation.NAVIGATION_UI)
    implementation(Lib.Navigation.NAVIGATION_FRAGMENT)

    /* Facebook Login */
    implementation(Lib.Facebook.FACEBOOK_LOGIN)

    /* MultiDex */
    implementation(Lib.MultiDex.MULTIDEX)

    /* Firebase Sign In */
    implementation(Lib.Firebase.FIREBASE_LOGIN)

    /* Coroutines Play Service */
    implementation(Lib.CoroutinesPlayService.COROUTINES_PLAY_SERVICE)

    /* Unit Testing */
    testImplementation(TestLib.JUNIT)
    testImplementation(TestLib.CORE_TEST)
    testImplementation(TestLib.ANDROID_JUNIT)
    testImplementation(TestLib.MOCK_WEB_SERVER)
    testImplementation(TestLib.ROBO_ELECTRIC)
    testImplementation(TestLib.COROUTINES)
    testImplementation(TestLib.MOCKK)
    testImplementation(TestLib.ANDROID_JUNIT_KTX)
    testImplementation(TestLib.ESPRESSOO)
    testImplementation(TestLib.ARCH_CORE)

    /* Android UI Testing */
    implementation(AndroidTestLib.CORE)
    androidTestImplementation(AndroidTestLib.JUNIT)
    androidTestImplementation(AndroidTestLib.EXT_JUNIT)
    androidTestImplementation(AndroidTestLib.ESPRESSO_CORE)
    androidTestImplementation(AndroidTestLib.ESPRESSO_CONTRIB)
    implementation(AndroidTestLib.FRAGMENT_TESTING)
    androidTestImplementation(AndroidTestLib.MOCKK)
    androidTestImplementation(AndroidTestLib.RUNNER)
    androidTestImplementation(AndroidTestLib.RULES)
    implementation(AndroidTestLib.ESPRESSO_IDLING_RESOURCE)
    androidTestImplementation(AndroidTestLib.ESPRESSO_INTENTS)
    androidTestImplementation(AndroidTestLib.CORE_VERSION)
    androidTestImplementation(AndroidTestLib.EXT_JUNIT_VERSION)
    androidTestImplementation("androidx.navigation:navigation-testing:2.3.5")
}
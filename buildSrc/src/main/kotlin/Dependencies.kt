

/** This file contains versions of all the dependencies used in the module  */

object BuildPlugins {
    private const val TOOLS_BUILD_GHRADLE = "7.0.0-alpha08"
    private const val KT_LINT = "9.2.1"
    private const val SAFE_ARGS = "2.3.0"
    private const val GOOGLE_SERVICE_VERSION = "4.3.3"
    private const val HILT_VERSION = "2.33-beta"
    const val TOOLS_BUILD_GRADLE =
        "com.android.tools.build:gradle:${TOOLS_BUILD_GHRADLE}"
    const val KTLINT_GRADLE_PLUGIN =
        "org.jlleitschuh.gradle:ktlint-gradle:${KT_LINT}"
    const val SAFE_ARGS_GRADLE_PLUGIN =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${SAFE_ARGS}"
    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
    const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
    const val KOTLIN_PARCELABLE_PLUGIN = "kotlin-parcelize"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val SAFE_ARGS_PLUGIN = "androidx.navigation.safeargs.kotlin"
    const val GOOGLE_SERVICE = "com.google.gms:google-services:$GOOGLE_SERVICE_VERSION"
    const val GOOGLE_GRADLE_SERVICES = "com.google.gms.google-services"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
}

object Lib {

    object Kotlin {
        const val KOTLIN_VERSION = "1.4.21"
        private const val KTX_CORE_VERSION = "1.2.0"

        const val KT_STD = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KOTLIN_VERSION}"
        const val KTX_CORE = "androidx.core:core-ktx:${KTX_CORE_VERSION}"
    }

    object Android {
        private const val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
        private const val MATERIAL_DESIGN_VERSION = "1.1.0"
        private const val LIFECYCLE_VIEWMODEL_KTX_VERSION = "2.2.0"
        private const val FRAGMENT_VERSION = "1.2.5"

        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${CONSTRAINT_LAYOUT_VERSION}"
        const val MATERIAL_DESIGN =
            "com.google.android.material:material:${MATERIAL_DESIGN_VERSION}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE_VIEWMODEL_KTX_VERSION}"
        const val FRAGMENT =
            "androidx.fragment:fragment-ktx:${FRAGMENT_VERSION}"
        const val APPCOMPAT =
            "androidx.appcompat:appcompat:1.2.0"
    }

    object Database {
        private const val ROOM_VERSION = "2.2.5"
        const val ROOM = "androidx.room:room-runtime:${ROOM_VERSION}"
        const val ROOM_DATABASE_COMPILER = "androidx.room:room-compiler:${ROOM_VERSION}"
    }

    object Di {
        private const val DAGGER_VERSION = "2.27"
        const val DAGGER = "com.google.dagger:dagger:${DAGGER_VERSION}"
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${DAGGER_VERSION}"
        const val DAGGER_ANDROID = "com.google.dagger:dagger-android-support:${DAGGER_VERSION}"
        const val DAGGER_PROCESSOR = "com.google.dagger:dagger-android-processor:${DAGGER_VERSION}"
    }

    object Async {
        private const val COROUTINES_VERSION = "1.3.7"

        const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${COROUTINES_VERSION}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${COROUTINES_VERSION}"
    }

    object Networking {
        private const val RETROFIT_VERSION = "2.9.0"
        private const val OKHTTP_LOGGING = "4.7.2"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${RETROFIT_VERSION}"
        const val RETROFIT_GSON =
            "com.squareup.retrofit2:converter-gson:${RETROFIT_VERSION}"
        const val LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${OKHTTP_LOGGING}"
    }

    object Serialization {
        private const val GSON_VERSION = "2.8.6"
        const val GSON = "com.google.code.gson:gson:${GSON_VERSION}"
    }

    object Logger {
        private const val TIMBER_VERSION = "4.7.1"
        const val TIMBER = "com.jakewharton.timber:timber:${TIMBER_VERSION}"
    }

    object ImageLibrary {
        private const val GLIDE_VERSION = "4.11.0"
        const val GLIDE = "com.github.bumptech.glide:glide:${GLIDE_VERSION}"
    }

    object Navigation {
        private const val NAVIGATION_COMPONENT_VERSION = "2.3.4"
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_COMPONENT_VERSION"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui-ktx:$NAVIGATION_COMPONENT_VERSION"
    }

    object Facebook {
        private const val FACEBOOK_LOGIN_VERSION = "[8,9)"
        const val FACEBOOK_LOGIN = "com.facebook.android:facebook-login:$FACEBOOK_LOGIN_VERSION"
    }

    object MultiDex {
        private const val MULTIDEX_VERSION = "2.0.1"
        const val MULTIDEX = "androidx.multidex:multidex:$MULTIDEX_VERSION"
    }

    object Firebase {
        private const val FIREBASE_LOGIN_VERSION = "19.2.0"
        const val FIREBASE_LOGIN = "com.google.firebase:firebase-auth:$FIREBASE_LOGIN_VERSION"
    }

    object CoroutinesPlayService {
        private const val COROUTINES_PLAY_SERVICE_VERSION = "1.1.1"
        const val COROUTINES_PLAY_SERVICE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$COROUTINES_PLAY_SERVICE_VERSION"
    }

    object DaggerHilt {
        private const val HILT_VERSION = "2.33-beta"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:$HILT_VERSION"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:$HILT_VERSION"
    }

}

object TestLib {
    private const val COROUTINES_VERSION = "1.3.7"
    private const val ANDROID_JUNIT_VERSION = "1.1.2"
    private const val ROBO_ELECTRIC_VERSION = "4.3"
    private const val ARCH_CORE_VERSION = "2.1.0"
    private const val MOCK_WEB_SERVER_VERSION = "4.7.2"
    private const val CORE_TEST_VERSION = "1.3.0"
    private const val JUNIT_VERSION = "4.13.2"
    private const val ESPRESSO_VERSION = "3.3.0"
    private const val MOCKK_VERSION = "1.9.3"

    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${COROUTINES_VERSION}"
    const val ROBO_ELECTRIC = "org.robolectric:robolectric:${ROBO_ELECTRIC_VERSION}"
    const val MOCK_WEB_SERVER =
        "com.squareup.okhttp3:mockwebserver:${MOCK_WEB_SERVER_VERSION}"
    const val CORE_TEST = "androidx.test:core-ktx:${CORE_TEST_VERSION}"
    const val JUNIT = "junit:junit:${JUNIT_VERSION}"
    const val ANDROID_JUNIT_KTX = "androidx.test.ext:junit:${ANDROID_JUNIT_VERSION}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit-ktx:${ANDROID_JUNIT_VERSION}"
    const val MOCKK = "io.mockk:mockk:$MOCKK_VERSION"
    const val ESPRESSOO = "androidx.test.espresso:espresso-core$ESPRESSO_VERSION"
    const val ARCH_CORE = "androidx.arch.core:core-testing:${ARCH_CORE_VERSION}"
}

object AndroidTestLib {

    // Espresso
    private const val ESPRESSO_VERSION = "3.1.0"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:$ESPRESSO_VERSION"
    const val ESPRESSO_IDLING_RESOURCE =
        "androidx.test.espresso:espresso-idling-resource:$ESPRESSO_VERSION" //use implementation
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$ESPRESSO_VERSION"
    const val ESPRESSO_INTENTS = "androidx.test.espresso:espresso-intents:3.1.0"


    // androidx.test
    private const val ANDROIDX_TEST = "1.1.0"
    const val RUNNER = "androidx.test:runner:$ANDROIDX_TEST"
    const val RULES = "androidx.test:rules:1.2.0"
    const val CORE = "androidx.test:core:$ANDROIDX_TEST"
    const val EXT_JUNIT = "androidx.test.ext:junit:$ANDROIDX_TEST"

    const val CORE_VERSION = "androidx.test:core-ktx:$ANDROIDX_TEST"
    const val EXT_JUNIT_VERSION = "androidx.test.ext:junit-ktx:$ANDROIDX_TEST"

    const val JUNIT = "junit:junit:4.13.2"
    const val MOCKK = "io.mockk:mockk-android:1.10.0"

    // androidx.fragment
    private const val FRAGMENT_TEST_VERSION = "1.2.5"
    const val FRAGMENT_TESTING =
        "androidx.fragment:fragment-testing:$FRAGMENT_TEST_VERSION" //use debugImplementation
}

object DebugLib {
    private const val LEAK_CANARY_VERSION = "2.3"
    const val LEAK_CANARY =
        "com.squareup.leakcanary:leakcanary-android:${LEAK_CANARY_VERSION}"
}

# InstaClone

## About
It is an instagram clone app which is based on Clean Architecture.
It uses Firebase for login/signup, Kotlin Coroutines for asynchronous calls, Room Persistance Library for offline storage,
Navigation Component for BottomNavigation,Espresso,Junit,MockK for testing and other best pratices as recommended by Google.The app is still under development.

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) -
    - [Dagger](https://dagger.dev/) - Dagger is a fully static, compile-time dependency injection framework for Java, Kotlin, and Android.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.
- [Firebase Password Authentication](https://firebase.google.com/docs/auth/android/password-auth) - Lets your users authenticate with Firebase using their email addresses and passwords.
- [Espresso](https://developer.android.com/training/testing/ui-testing/espresso-testing) - Provides APIs for writing UI tests to simulate user interactions within a single target app.
- [MockK](https://github.com/mockk/mockk) - Open source library focused on making mocking in Kotlin great.

## Architecture
This app uses ***Clean Architecture***
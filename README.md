# TestGPT Android App

TestGPT is an Android application that integrates with the Blenderbot-400M-distill API, allowing users to interact with a chatbot. The app is developed using Kotlin and follows best practices for Android development, including the use of Retrofit for networking, ProGuard (R8) for code obfuscation, and GitHub Actions for continuous integration (CI) and automated APK generation.

## Features

- **Interactive Chatbot**: Users can interact with a Blenderbot-400M-distill powered chatbot.
- **Clean UI/UX**: Custom-designed chat bubbles and a user-friendly interface.
- **Dark and Light Themes**: Supports both light and dark modes.
- **Offline Handling**: The app gracefully handles network issues and provides appropriate messages when the user is offline.

## Tech Stack

- **Kotlin**: The main programming language used for Android development.
- **Retrofit**: A type-safe HTTP client for making API calls.
- **ProGuard (R8)**: For code shrinking, obfuscation, and optimization.
- **Android SDK**: The official Android development framework.
- **Gradle**: Build automation tool.
- **GitHub Actions**: For continuous integration (CI) and continuous deployment (CD) to automate APK generation.

## Setup Instructions

Follow these steps to get the project up and running on your local machine.

### 1. Clone the Repository

Start by cloning the repository to your local machine:

```bash
git clone https://github.com/testtool-ui/App.git
cd App
```

### 2. Open the Project in Android Studio

1. Open **Android Studio**.
2. Select **Open an existing project**.
3. Navigate to the folder where you cloned the repository and open it.

### 3. Set Up Gradle

Gradle should sync automatically. If it doesn't, run the following command to sync the project:

```bash
./gradlew build
```

This will download any dependencies and build the project.

### 4. Set Up API Keys

This app connects to the **TestGPT API**, which is hosted on **Render**. To configure or update the API endpoint, modify the `api_url` in the appropriate Kotlin file. If using sensitive API keys, consider using environment variables or a secure configuration file.

## Build and Run

You can build the APK directly from **Android Studio** or use **GitHub Actions** for automated builds.

### 1. Build APK Locally (Android Studio)

- Open Android Studio and go to **Build** > **Build APK**.
- You can find the generated APK in `app/build/outputs/apk/release/`.

### 2. Build APK with GitHub Actions

This project uses **GitHub Actions** for automated builds. Whenever you push changes to the `main` branch or submit a pull request, the APK will be built automatically, and an artifact will be generated.

To trigger a manual build, push your changes to GitHub:

```bash
git push origin main
```

Once the build completes, you can download the **debug APK** from the **Artifacts** section in GitHub Actions.

## ProGuard (R8) Configuration

To make reverse engineering difficult and reduce the APK size, **ProGuard** is enabled in the `release` build. The `proguard-rules.pro` file ensures that essential code is kept intact while unnecessary parts are obfuscated.

### Example ProGuard Rules

```pro
# Keep the application entry point
-keep class com.mdselim.testgpt.** { *; }

# Keep classes needed by Retrofit and Gson
-keep class com.squareup.** { *; }
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.google.gson.** { *; }

# Keep AndroidX and Material components
-keep class androidx.** { *; }
-keep class com.google.android.material.** { *; }

# Suppress warnings for Retrofit, Gson, and OkHttp
-dontwarn com.squareup.**
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn com.google.gson.**
```

## Acknowledgements

- **Retrofit** for handling networking.
- **ProGuard** for code shrinking and obfuscation.
- **GitHub Actions** for CI/CD and automated APK generation.

# Keep the application entry point
-keep class com.mdselim.testgpt.** { *; }

# Keep classes required by Retrofit and Gson
-keep class com.squareup.** { *; }
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.google.gson.** { *; }
-keepclassmembers class * {
    @retrofit2.http.* <methods>;
}

# Keep AndroidX and Material Design components
-keep class androidx.** { *; }
-keep class com.google.android.material.** { *; }

# Keep generated Kotlin classes
-keep class kotlin.** { *; }
-keep class kotlin.jvm.** { *; }

# Suppress warnings for Retrofit, Gson, and OkHttp
-dontwarn com.squareup.**
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn com.google.gson.**

# Optimization settings
-optimizationpasses 5
-dontoptimize
-dontpreverify
-verbose

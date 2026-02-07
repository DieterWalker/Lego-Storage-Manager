plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    /** Plugin bổ sung các thư viện ksp */
    id("com.google.devtools.ksp") version "2.3.5"
}

android {
    namespace = "com.example.legostoragemanager"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.legostoragemanager"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
//    implementation("com.google.dagger:dagger-compiler:2.51.1")
////    ksp("com.google.dagger:dagger-compiler:2.51.1")
    /** Thư viện nền tảng của Android / Kotlin */
    implementation(libs.androidx.core.ktx)
    /** Thư viện quản lý vòng đời của Activity */
    implementation(libs.androidx.lifecycle.runtime.ktx)
    /** Thư viện Jetpack Composer */
    implementation(libs.androidx.activity.compose)
    /** Compose BOM (Bill of Materials) */
    implementation(platform(libs.androidx.compose.bom))
    /** Thư viện xây giao diện (Composer UI) và đồ họa (Composer Graphics) */
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    /** Thư viện cho phép tạo các bản xem trước @Preview */
    implementation(libs.androidx.compose.ui.tooling.preview)
    /** Thư viện Material 3 cung cấp Button, TextField, Theme... */
    implementation(libs.androidx.compose.material3)
    /** Thư viện cung cấp Navigation cho chương trình*/
    implementation(libs.androidx.navigation.compose)
    /** Thư viện Junit hỗ trợ kiểm thử */
    testImplementation(libs.junit)
    /** Thư viện hỗ trợ chạy test trên thiết bị / máy ảo */
    androidTestImplementation(libs.androidx.junit)
    /** Thư viện Test UI (View-based) */
    androidTestImplementation(libs.androidx.espresso.core)
    /** Đồng bộ BOM với Compose UI Test  */
    androidTestImplementation(platform(libs.androidx.compose.bom))
    /** Thư viện Compose UI Testing */
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    /** Thư viện hỗ trợ Layout Inspector và Debug recomposition */
    debugImplementation(libs.androidx.compose.ui.tooling)
    /** Thư viện Manifest riêng cho Compose UI Test */
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    /** Thư viện cho Room:
     * + Core của Room
     * + Đọc @Entity, @Dao, tự động sin code SQL + implementation
     * + Kotlin Extensions
     * */
    implementation("androidx.room:room-runtime:${rootProject.extra["room_version"]}")
    implementation("androidx.core:core-ktx:1.15.0")
    ksp("androidx.room:room-compiler:${rootProject.extra["room_version"]}")
    implementation("androidx.room:room-ktx:${rootProject.extra["room_version"]}")

}
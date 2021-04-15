plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
    }
}

dependencies {
    implementation(kotlin("stdlib-js"))
}
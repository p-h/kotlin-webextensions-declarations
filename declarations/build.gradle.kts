plugins {
    id("org.jetbrains.kotlin.js")
    `maven-publish`
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
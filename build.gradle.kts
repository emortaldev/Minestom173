plugins {
    id("java")
}

group = "ca.spottedleaf"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("net.minestom:minestom:2025.07.27-1.21.8")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}
plugins {
    kotlin("jvm") version "2.0.0-RC3"
}

group = "com.serranofp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
    compilerOptions.freeCompilerArgs.addAll("-Xwhen-guards")
    compilerOptions.freeCompilerArgs.addAll("-Xmulti-dollar-interpolation")
    compilerOptions.freeCompilerArgs.addAll("-Xcontext-receivers")
}
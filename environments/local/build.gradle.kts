import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    `java-library`
}

repositories {
    jcenter()
}

sourceSets.main {
    withConvention(KotlinSourceSet::class) {
        // Put components and bases here (src)
        kotlin.srcDirs(
                "../../bases/restapi/src",
                "../../components/character/src")
    }
}

sourceSets.test {
    withConvention(KotlinSourceSet::class) {
        // Put test components and bases here
        kotlin.srcDirs(
                "../../bases/restapi/test",
                "../../components/character/test")
    }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.javalin:javalin:3.9.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    implementation("org.slf4j:slf4j-simple:1.8.0-beta4")
    implementation(project(":components:book"))
}

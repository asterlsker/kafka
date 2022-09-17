import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

java.sourceCompatibility = JavaVersion.VERSION_17
tasks.jar { enabled = true }
tasks.bootJar { enabled = false }

allprojects {
    group = "com.asterlker"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        // Kotlin Standard Library
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Spring Boot Starter
        implementation("org.springframework.boot:spring-boot-starter-web")

        // Test
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        // Annotation Processing Tool
    }

    sourceSets.main.configure {
        resources.srcDirs("src/main/resources/common","src/main/resources/config")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}


project("server-delivery") {
// port: 8081
}

project("server-logging") {
// port: 8082
}

project("server-message") {
// port: 8083
}


project("server-order") {
// port: 8084
}
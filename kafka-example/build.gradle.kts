import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_17
tasks.jar { enabled = false }
tasks.bootJar { enabled = false }

allprojects {
    group = "com.asterlker"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

val application = listOf("application");
val common = listOf("common");
val nonDependenciesProjects = application + common
configure(subprojects.filter { it.name !in nonDependenciesProjects }) {

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

    allOpen{
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    noArg {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    dependencies {
        // Kotlin Standard Library
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Spring Boot Starter
        implementation("org.springframework.boot:spring-boot-starter-web")

        // Databasse
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        runtimeOnly("com.h2database:h2")

        // Test
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        // Annotation Processing Tool

        // kafka
        // https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka
        implementation("org.springframework.kafka:spring-kafka:2.9.0") {
            exclude("org.apache.kafka", "kafka-clients")
        }
        implementation("org.apache.kafka:kafka-clients:3.2.1")
    }

    sourceSets.main.configure {
        resources.srcDirs("src/main/resources/common", "src/main/resources/config")
    }

    tasks.processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
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


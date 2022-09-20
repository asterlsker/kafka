sourceSets.main.configure {
    resources.srcDirs(
        "src/main/resources/common",
        "src/main/resources/config",
        "src/main/resources/sql"
    )
}

tasks.jar { enabled = true }
tasks.bootJar { enabled = false }
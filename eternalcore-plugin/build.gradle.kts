plugins {
    `eternalcode-java`
    `eternalcore-repositories`
    `eternalcore-shadow-compiler`
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

eternalShadowCompiler {
    module(":eternalcore-core")

    pluginYml {
        main = "com.eternalcode.core.loader.EternalCoreLoader"
        apiVersion = "1.21.1"
        prefix = "EternalCore"
        authors = listOf("EternalCodeTeam", "Portero")
        name = "EternalCore"
        description = "All the most important server functions in one!"
        website = "www.eternalcode.pl"
        version = "${project.version}"
        softDepend = listOf("PlaceholderAPI")
    }

    shadowJar {
        archiveFileName.set("EternalCore-${project.version}.jar")

        exclude(
            "META-INF/**",
        )

        dependsOn(":eternalcore-core:test")
        dependsOn(":eternalcore-core:checkstyleMain")
    }
}

dependencies {
    implementation("com.spotify:completable-futures:${Versions.SPOTIFY_COMPLETABLE_FUTURES}")
}

tasks {
    runServer {
        minecraftVersion("1.21.1")
    }
}

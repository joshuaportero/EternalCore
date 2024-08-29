plugins {
    `eternalcode-java`
    `eternalcode-java-test`
    `eternalcore-repositories`
    `eternalcore-shadow`
}

dependencies {
    // Base libraries
    compileOnly("org.jetbrains:annotations:${Versions.JETBRAINS_ANNOTATIONS}")

    // Minecraft & Bridges API
    compileOnlyApi("io.papermc.paper:paper-api:${Versions.PAPER_API}")
    compileOnly("me.clip:placeholderapi:${Versions.PLACEHOLDER_API}")

    // Lombok
    compileOnly("org.projectlombok:lombok:${Versions.LOMBOK}")
    annotationProcessor("org.projectlombok:lombok:${Versions.LOMBOK}")

    // GitCheck
    implementation("com.eternalcode:gitcheck:${Versions.GIT_CHECK}")

    testImplementation("com.eternalcode:eternalcode-commons-bukkit:${Versions.ETERNALCODE_COMMONS}")
}

eternalShadow {
    // Paper and Adventure libraries
    library("io.papermc:paperlib:${Versions.PAPER_LIB}")
    libraryRelocate(
        "io.papermc.lib",
        "com.google.gson",
    )

    // configuration
    library("net.dzikoysk:cdn:${Versions.CDN_CONFIGS}")
    libraryRelocate(
        "net.dzikoysk.cdn"
    )

    // Multification
    library("com.eternalcode:multification-bukkit:${Versions.MULTIFICATION}")
    library("com.eternalcode:multification-cdn:${Versions.MULTIFICATION}")
    libraryRelocate(
        "com.eternalcode.multification",
    )

    // EternalCode Commons
    library("com.eternalcode:eternalcode-commons-bukkit:${Versions.ETERNALCODE_COMMONS}")
    library("com.eternalcode:eternalcode-commons-adventure:${Versions.ETERNALCODE_COMMONS}")
    libraryRelocate(
        "com.eternalcode.commons",
    )

    // database
    library("org.mariadb.jdbc:mariadb-java-client:${Versions.MARIA_DB}")
    library("org.postgresql:postgresql:${Versions.POSTGRESQL}")
    library("com.h2database:h2:${Versions.H2}")
    library("com.j256.ormlite:ormlite-core:${Versions.ORMLITE}")
    library("com.j256.ormlite:ormlite-jdbc:${Versions.ORMLITE}")
    library("com.zaxxer:HikariCP:${Versions.HIKARI_CP}")

    // command framework & skull library
    library("dev.rollczi:liteskullapi:${Versions.LITE_SKULL_API}")
    library("dev.rollczi:litecommands-bukkit:${Versions.LITE_COMMANDS}")
    library("dev.rollczi:litecommands-adventure:${Versions.LITE_COMMANDS}")
    libraryRelocate(
        "dev.rollczi.litecommands",
        "dev.rollczi.liteskullapi"
    )

    // common libraries
    library("org.panda-lang:expressible:${Versions.EXPRESSIBLE}")
    library("org.panda-lang:panda-utilities:${Versions.PANDA_UTILITIES}")
    library("commons-io:commons-io:${Versions.APACHE_COMMONS}")
    libraryRelocate(
        "panda.std",
        "panda.utilities",
        "org.apache.commons.io",
    )

    // gui library
    library("dev.triumphteam:triumph-gui:${Versions.TRIUMPH_GUI}")
    libraryRelocate("dev.triumphteam")

    // caffeine
    library("com.github.ben-manes.caffeine:caffeine:${Versions.CAFFEINE}")
    libraryRelocate("com.github.benmanes.caffeine");
}

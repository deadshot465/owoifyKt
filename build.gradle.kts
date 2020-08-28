plugins {
    `maven-publish`
    kotlin("jvm") version "1.4.0"
    id("org.jetbrains.dokka") version "1.4.0-rc"
    id("com.jfrog.bintray") version "1.8.5"
}

project.group = "org.deadshot465"
project.version = "1.1"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(group = "io.github.cdimascio", name = "java-dotenv", version = "5.2.1")
    testImplementation("junit:junit:4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>("owoifyKt") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])

            artifact(sourcesJar)

            pom.withXml {
                asNode().apply {
                    appendNode("description", "Turning your worst nightmare into a Kotlin package https://codepen.io/newbeetf2/pen/yLLaNPZ")
                    appendNode("name", rootProject.name)
                    appendNode("url", "https://github.com/deadshot465/owoifyKt")
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", "MIT")
                        appendNode("url", "https://opensource.org/licenses/mit-license.php")
                        appendNode("distribution", "repo")
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", "deadshot465")
                        appendNode("name", "Tetsuki Syu")
                    }
                    appendNode("scm").apply {
                        appendNode("url", "https://github.com/deadshot465/owoifyKt")
                    }
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    publish = true

    setPublications("owoifyKt")

    pkg.apply {
        repo = "owoifyKt"
        name = project.name
        userOrg = "chehui-chou"
        githubRepo = "deadshot465/owoifyKt"
        vcsUrl = "https://github.com/deadshot465/owoifyKt"
        description = "Turning your worst nightmare into a Kotlin package https://codepen.io/newbeetf2/pen/yLLaNPZ"
        setLabels("kotlin", "owoify", "owoness", "owo", "uwu", "uvu", "babyspeak", "nonsensical", "fun")
        setLicenses("MIT")
        desc = description
        websiteUrl = "https://github.com/deadshot465/owoifyKt"
        issueTrackerUrl = "https://github.com/deadshot465/owoifyKt/issues"
        githubReleaseNotesFile = "README.md"

        version.apply {
            name = project.version.toString()
            desc = "Turning your worst nightmare into a Kotlin package https://codepen.io/newbeetf2/pen/yLLaNPZ"
            released = "2020-08-29"
            vcsTag = project.version.toString()
        }
    }
}
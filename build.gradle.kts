import java.util.Properties
import java.io.*

plugins {
    `maven-publish`
    signing
    kotlin("jvm") version "1.5.0"
    id("org.jetbrains.dokka") version "1.4.32"
}

project.group = "io.github.deadshot465"
project.version = "1.0"

ext["signing.keyId"] = ""
ext["signing.password"] = ""
ext["signing.secretKeyRingFile"] = ""
ext["ossrhUsername"] = ""
ext["ossrhPassword"] = ""
ext["sonatypeStagingProfileId"] = ""

val secretPropertiesFile = project.rootProject.file("local.properties")
if (secretPropertiesFile.exists()) {
    val p = Properties()
    val fs = FileInputStream(secretPropertiesFile)
    p.load(fs)
    fs.close()
    p.forEach { name, value -> ext[name.toString()] = value.toString() }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
    ext["sonatypeStagingProfileId"] = System.getenv("SONATYPE_STAGING_PROFILE_ID")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit:junit:4.13")
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.32")
    dokkaJavadocPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.4.32")

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

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        create<MavenPublication>("owoifyKt") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])

            artifact(sourcesJar)
            artifact(javadocJar)

            pom {
                name.set(rootProject.name)
                description.set("A simple library that turns any string into nonsensical babyspeak, ported from mohan-cao's owoify-js.")
                url.set("https://github.com/deadshot465/owoifyKt")

                licenses {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/mit-license.php")
                }

                developers {
                    developer {
                        name.set("Chehui Chou")
                        id.set("deadshot465")
                        email.set("tetsuki.syu1315@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:github.com/deadshot465/owoifyKt.git")
                    developerConnection.set("scm:git:ssh://github.com/deadshot465/owoifyKt.git")
                    url.set("https://github.com/deadshot465/owoifyKt")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}
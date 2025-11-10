plugins {
    id("java")
    id("org.sonarqube") version "7.0.1.6134"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

sonar {
    properties {
        property("sonar.projectKey", "tofu-org_vinlab")
        property("sonar.organization", "tofu-org")
    }
}

tasks.test {
    useJUnitPlatform()
}
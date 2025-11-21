plugins {
    id("java")
    id("application")
}

group = "org.teamwork"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.googlecode.lanterna:lanterna:3.1.2")
}

application {
    mainClass.set("org.teamwork.Main")
}

tasks.named<JavaExec>("run") {
    jvmArgs("-Dlanterna.terminal.WindowsTerminal.inProcessTerminal=true")
}

tasks.test {
    useJUnitPlatform()
}
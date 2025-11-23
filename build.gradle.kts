plugins {
	id("java")
	id("application")
}

group = "org.teamwork"
version = "1.0-SNAPSHOT"

application {
	mainClass.set("org.teamwork.Main")
}

dependencies {
	// https://mvnrepository.com/artifact/org.junit/junit-bom
	testImplementation(platform("org.junit:junit-bom:6.1.0-M1"))
	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
	testImplementation("org.junit.jupiter:junit-jupiter-api:6.1.0-M1")
	// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-launcher
	testImplementation("org.junit.platform:junit-platform-launcher:6.1.0-M1")
	// https://mvnrepository.com/artifact/com.googlecode.lanterna/lanterna
	implementation("com.googlecode.lanterna:lanterna:3.1.3")
}

java {
	sourceCompatibility = JavaVersion.VERSION_25
	targetCompatibility = JavaVersion.VERSION_25
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
		vendor = JvmVendorSpec.ADOPTIUM
	}
}

repositories {
	mavenCentral()
}

tasks {
	named<JavaExec>("run") {
		jvmArgs("-Dlanterna.terminal.WindowsTerminal.inProcessTerminal=true")
	}
	test {
		useJUnitPlatform()
	}
	wrapper {
		gradleVersion = "9.2.1"
	}
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.0.4"
  id("io.spring.dependency-management") version "1.1.0"
  id("com.ncorti.ktfmt.gradle") version "0.11.0"
  kotlin("jvm") version "1.8.10"
  kotlin("plugin.spring") version "1.8.10"
}

group = "app.flux"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.liquibase:liquibase-core")
  implementation("io.jsonwebtoken:jjwt-api:0.11.5")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("io.micrometer:micrometer-registry-prometheus")
  runtimeOnly("org.postgresql:postgresql")
  runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.5")
  runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.5")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.security:spring-security-test")
  testRuntimeOnly("com.h2database:h2")
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

ktfmt {
  googleStyle()
}

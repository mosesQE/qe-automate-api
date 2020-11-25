name := "qe-automate-api"

version := "0.1"

scalaVersion := "2.13.4"

// https://mvnrepository.com/artifact/org.scalactic/scalactic
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

// https://mvnrepository.com/artifact/io.rest-assured/rest-assured
libraryDependencies += "io.rest-assured" % "rest-assured" % "4.3.2" % Test

// https://mvnrepository.com/artifact/io.rest-assured/scala-support
libraryDependencies += "io.rest-assured" % "scala-support" % "4.3.2" % Test

// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.7.0" % Test

// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.3"

// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis (old 2.5.3 to work)
libraryDependencies += "com.github.scribejava" % "scribejava-apis" % "2.5.3"

// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-httpclient-okhttp
libraryDependencies += "com.github.scribejava" % "scribejava-httpclient-okhttp" % "8.0.0" % Test

// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.3"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.3"


// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis (old 2.5.3 to work)
libraryDependencies += "com.github.scribejava" % "scribejava-apis" % "2.5.3"

// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-httpclient-okhttp
libraryDependencies += "com.github.scribejava" % "scribejava-httpclient-okhttp" % "8.0.0" % Test

// hacks for a solution follow:
//libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
//testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
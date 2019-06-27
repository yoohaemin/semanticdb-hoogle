import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "semanticdb-hoogle",
    libraryDependencies ++= Seq(
      "org.scalameta" %% "semanticdb" % "4.1.6",
      "org.scalaz" %% "scalaz-core" % "7.3.0-M30",
      "org.scalaz" %% "scalaz-zio" % "1.0-RC5",
      scalaTest % Test,
    )
  )


name := "finagle-http-ex1"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "6.41.0",
  "com.typesafe.play" %% "play-json" % "2.5.10",
  "ai.x" %% "play-json-extensions" % "0.8.0"

)
//Revolver.settings

val circeVersion = "0.6.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-optics"
).map(_ % circeVersion)
    
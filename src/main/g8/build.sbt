// voir http://www.wartremover.org/
lazy val warts =
  Warts.allBut()

lazy val globalSettings: Seq[sbt.Def.SettingsDefinition] =
  Seq(
    inThisBuild(
      List(
        organization := "com.example",
        scalaVersion := "2.13.0",
        version := "0.1.0-SNAPSHOT"
      )),
    updateOptions := updateOptions.value.withCachedResolution(true),
    wartremoverErrors in (Compile, compile) := warts,
    wartremoverWarnings in (Compile, console) := warts,
    addCompilerPlugin("io.tryp" % "splain" % "0.4.1" cross CrossVersion.patch),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    scalafmtOnCompile := true,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

lazy val root =
  project
    .in(file("."))
    .settings(globalSettings : _*)
    .settings(name := "test-seed")
// shadow sbt-scalajs' crossProject and CrossType until Scala.js 1.0.0 is released
import sbtcrossproject.{crossProject, CrossType}

// voir http://www.wartremover.org/
lazy val warts =
  Warts.allBut()

lazy val globalSettings: Seq[sbt.Def.SettingsDefinition] =
  Seq(
    inThisBuild(
      List(
        organization := "com.example",
        scalaVersion := "2.12.7",
        version := "0.1.0-SNAPSHOT"
      )),
    updateOptions := updateOptions.value.withCachedResolution(true),
    wartremoverErrors in (Compile, compile) := warts,
    wartremoverWarnings in (Compile, console) := warts,
    addCompilerPlugin("io.tryp" % "splain" % "0.3.4" cross CrossVersion.patch),
    addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.8" cross CrossVersion.binary),
    scalafmtOnCompile := true,
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.5" % Test
  )

lazy val root =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .in(file("."))
    .settings(globalSettings : _*)
    .settings(name := "$name$")

lazy val rootJS = root.js
lazy val rootJVM = root.jvm

enablePlugins(JavaAppPackaging)

// voir http://www.wartremover.org/
lazy val warts = {
  import Wart._
  List(
    ArrayEquals,
    AsInstanceOf,
    Enumeration,
    Equals,
    ExplicitImplicitTypes,
    FinalCaseClass,
    IsInstanceOf,
    JavaSerializable,
    LeakingSealed,
    Null,
    Option2Iterable,
    OptionPartial,
    Product,
    PublicInference,
    Return,
    Serializable,
    StringPlusAny,
    TraversableOps,
    TryPartial
  )
}

lazy val catsVersion = "2.0.0-RC2"
lazy val enumeratumVersion = "1.5.13"

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
    libraryDependencies ++= Seq(
      "com.beachape" %% "enumeratum" % enumeratumVersion,
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-effect" % catsVersion,
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )

lazy val root =
  project
    .in(file("."))
    .settings(globalSettings : _*)
    .settings(name := "$name$")
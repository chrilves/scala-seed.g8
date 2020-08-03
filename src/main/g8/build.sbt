enablePlugins(JavaAppPackaging, ScalaJSPlugin)

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

lazy val catsVersion = "2.1.1"
lazy val enumeratumVersion = "1.5.15"

lazy val globalSettings: Seq[sbt.Def.SettingsDefinition] =
  Seq(
    inThisBuild(
      List(
        organization := "com.example",
        scalaVersion := "2.13.3",
        version := "0.1.0-SNAPSHOT"
      )),
    updateOptions := updateOptions.value.withCachedResolution(true),
    wartremoverErrors in (Compile, compile) := warts,
    wartremoverWarnings in (Compile, console) := warts,
    addCompilerPlugin("io.tryp" % "splain" % "0.5.1" cross CrossVersion.patch),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "com.beachape"  %%% "enumeratum"  % enumeratumVersion,
      "org.typelevel" %%% "cats-core"   % catsVersion,
      "org.typelevel" %%% "cats-effect" % catsVersion,
      "org.scalatest" %%% "scalatest" % "3.1.1" % Test
    )
  )

lazy val root =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .in(file("."))
    .settings(globalSettings:_*)
    .settings(name := "$name$")
    .jsSettings(scalaJSUseMainModuleInitializer := true)

lazy val rootJS     = root.js
lazy val rootJVM    = root.jvm
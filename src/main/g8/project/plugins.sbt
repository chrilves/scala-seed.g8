// Environnement
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.4")

// Développement
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.10")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.3.1")
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.13")
addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")

// Scala JS
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject"      % "1.0.0")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"                   % "1.1.1")

name := "scala-way"
val dottyVersion = "0.21.0-RC1"

version := "0.1"

scalaVersion := dottyVersion

libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.13" % "3.2.0-M2" % "test",
  "org.scalacheck" % "scalacheck_2.13" % "1.14.0" % "test")

javaOptions in Test ++= Seq("-Dconfig.file=ci.conf")



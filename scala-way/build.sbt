name := "scala-way"
val dottyVersion = "0.21.0-RC1"

version := "0.1"

scalaVersion := dottyVersion

libraryDependencies ++= Seq("org.scalacheck" % "scalacheck_2.13" % "1.14.0" % "test",
"com.novocode" % "junit-interface" % "0.11" % "test")

javaOptions in Test ++= Seq("-Dconfig.file=ci.conf")



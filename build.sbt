name := "mockito"

version := "0.1"

scalaVersion := "2.13.1"

resolvers += "Mockito" at "https://dl.bintray.com/mockito/maven/"

libraryDependencies += "org.mockito" %% "mockito-scala" % "1.13.3"

libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.1.1" % "test"
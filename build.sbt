name := "learning-scala-typesystem"

version := "0.1"

scalaVersion := "2.12.6"

//scalacOptions += "-Ypartial-unification"

resolvers += Resolver.sonatypeRepo("releases")

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.8")
import sbt._
object Dependencies {


  lazy val configVersion="1.4.1"

  lazy val config= "com.typesafe" % "config" %  configVersion

  def compileDependencies:Seq[ModuleID]=Seq(config)

}

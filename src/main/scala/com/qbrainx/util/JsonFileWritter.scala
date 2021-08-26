package com.qbrainx.util

import com.qbrainx.config.AppConfig

import java.io.PrintWriter
import scala.util.{Failure, Success, Try}

object JsonFileWritter {


  def jsonFile(path:String,input:String)={
    Try(new PrintWriter(path)) match {
      case Success(value)=>value.println(input)
        value.close()
      case Failure(exception)=>exception.printStackTrace()
    }
  }

}

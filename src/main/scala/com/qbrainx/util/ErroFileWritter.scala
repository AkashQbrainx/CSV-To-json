package com.qbrainx.util

import java.io.PrintWriter
import scala.util.{Failure, Success, Try}

object ErrorFileWritter {

  def errorFile(path:String)={
    Try(new PrintWriter(path)) match {
      case Success(value)=>value.println("no file found")
                           value.close()
      case Failure(exception)=>println("not able to perform such operation")
    }
  }


}

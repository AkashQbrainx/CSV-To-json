package com.qbrainx.util

import com.qbrainx.model.Student

import java.util
import java.util.stream.Collectors
import scala.util.{Success, Try}

object StudentMapper {
  def convertToStudent(input:util.List[(String, String, String, String)])=
    input.stream().map{f=>Some(f._1.toInt,f._2,f._3,f._4)}
      .map { f =>
        if (f.nonEmpty) {
          val a: (Int, String, String, String) = f.get
          val mobile = if (a._4 != null && a._4.nonEmpty) Some(a._4) else (None)
          Some(a._1, a._2, a._3,mobile)
        }
        else None
      }
        .map{tuple=>
          val a: (Int, String, String, Option[String]) =tuple.get
          Some(new Student(a._1, a._2, a._3, a._4))
        }
      .filter(_.nonEmpty).map(_.get).collect(Collectors.toList[Student])

  def jsonString(student: Student): String ={
   val id=
     s""""id":"{$student.id}","""

    val fName=
      s""" "fName":"${student.fName}","""

    val lName=
      s""""lName"="${student.lName}","""

    val mobile=
    if(student.Mobile.nonEmpty)
      s""""id":"${student.Mobile}""""
    else
      ""

    id+"\n"+fName+"\n"+lName+"\n"+mobile
  }
}

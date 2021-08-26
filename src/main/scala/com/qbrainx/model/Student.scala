package com.qbrainx.model

import com.qbrainx.util.StudentMapper.jsonString

import java.util
import java.util.stream.Collectors
import scala.util.Try

case class Student(id:Int,fName:String,lName:String,Mobile:Option[String]){


}
object Student{

  def convertToJson(students: util.List[Student]): String = {
    students
      .stream()
      .map(student => jsonString(student))
      .collect(Collectors.joining(",", "[", "]"))
  }
}
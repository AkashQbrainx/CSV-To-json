package com.qbrainx.model

import com.qbrainx.util.StudentMapper.jsonString

import java.util
import java.util.stream.Collectors
import scala.util.Try

case class Student(id:Int,fName:String,lName:String,Mobile:Option[String]){


}
object Student{
  def convertToJson(input: util.List[Student]): String = {
    input.stream().map( jsonString(_))
      .collect(Collectors.joining(",", "[", "]"))
  }

}
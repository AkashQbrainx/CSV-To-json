package com.qbrainx.App

import com.qbrainx.config.AppConfig
import com.qbrainx.config.AppConfig.config
import com.qbrainx.model.Student

import com.qbrainx.util.{CsvFileReader, ErrorFileWritter, JsonFileWritter, StudentMapper}
import com.typesafe.config.Config

import java.util
import scala.io.Source
import scala.util.{Failure, Success, Try}

object Main extends App {

  val source: String =AppConfig.config.getString("sourcepath")

  val fileStatus: Option[util.LinkedList[String]] =CsvFileReader.readCsvFile(source)

  if(fileStatus.isEmpty)
  {
    ErrorFileWritter.errorFile(AppConfig.config.getString("errorpath"))
  }else {
    val dataFromCsv: util.List[(String, String, String, String)] = StudentMapper.datafromCsv(fileStatus.get)

    val formatToStudent: util.List[Student] = StudentMapper.convertToStudent(dataFromCsv)
    val jsonString: String =Student.convertToJson(formatToStudent)
    val path: String =AppConfig.config.getString("outputpath")

    val output=JsonFileWritter.jsonFile(path,jsonString)
  }
}

package com.qbrainx.util

import com.qbrainx.App.Main.source
import com.qbrainx.config.AppConfig

import java.io.PrintWriter
import java.util
import java.util.stream.Collectors
import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

object CsvFileReader {
  def readCsvFile(inputpath: String):Some[util.LinkedList[String]] = {
    Try(Source.fromFile(inputpath)) match {
      case (Success(source: Source))=> {
        val readCsv: Iterator[String] = source.getLines()
        val list = new util.LinkedList[String]() {}
//        while (readCsv.hasNext) {
//        list.add(readCsv.next())
//        }

        Some.apply(list)
      }
      case Failure(exception) => {
       println("no files present")
        Some.apply(null)
      }
      }
    }



}
package cn.felord.datetime.convert.core

import java.net.URL

import scala.collection.mutable.ArrayBuffer
import scala.sys.process.Process

class run {

}

object aa extends App {

  val arr = ArrayBuffer(1, 23, 345, 23, 235, 34, 54, 543, 234, 12, 423, 4, 34, 3)
  val sortArr = arr.sortWith(_<_).mkString("<",",",">")
  val map = Map("b" -> 2,"a" -> 1)
  val sortMap = {
    map.toList.sortBy(_ _2)
  }
  map.getOrElse("c",Nil)
  val yMap = for ((k,v) <- map) yield(v,k)
  println(yMap)
  println(sortArr )
  println(sortMap)

  println("=--------------------------------")
  val tuple = (1,"w",301.4)
  val t = ("hahah","")
  val (int,"") = t
  println(int)
  println("sadasd2AWesfsA@DefFSDS".partition(_.isUpper))

  val  a = Array("<","-",">")
  val  b = Array(2,10,2)
  val tuple2 = a.zip(b)
  println(tuple2.toMap)
  for ((a,b) <- tuple2) Console.print(a * b)
  tuple2.foreach{
    e => print(e._1 * e._2)
  }
}


class Person {
  private var oldAge = 0
  def age: Int = oldAge
  def setAge(newAge:Int): Unit = if (newAge>oldAge) oldAge = newAge

}
object setAge extends App{
  val tom = new Person
  tom.setAge(5)
  println(tom.age)
  tom.setAge(2)
  println(tom.age)
  var flag = true
  flag = false
}
package cn.felord.datetime.convert

import java.net.InetAddress
import java.util.UUID
import java.math.BigDecimal
import lombok.extern.slf4j.Slf4j

import scala.annotation.tailrec
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Try}

class GetLocalHost {

}

@Slf4j
object host extends App {
  println(InetAddress.getLocalHost.getHostAddress)
  println(UUID.randomUUID().toString.replaceAll("-", "").toUpperCase())
  val list: List[String] = List("abc", "123", "=-!", "sadas89")
  //  println(list.toArray:_*)
  try {
    //    println("A".toInt)
    //    println("11".toInt )
    //    assert(1 > 1)
    //    println("未通过")
    val a = Long.box(1)
    val b = 1.toLong
    println(a.equals(b))
    println(a == b)
    println(a)
  } catch {
    case _: AssertionError =>
      println("捕获异常")
    case a: NumberFormatException =>
      println("类型错误", a)
  }
}


object rr extends App {
  val pl: () => Unit = () => {
    println("t头等功名")
  }
  pl()
  // 调用submit方法,完成其函数
  val a: Unit = submit {
    "我是"
  } {
    "哈哈"
  }
  // 调用a方法
  a

  // 定义两个函数
  def submit(executeBody: => String)(sss: => String): Unit = {
    // 最终对两个参数操作
    println(executeBody + ":" + sss)
  }
}


object gg extends App {
  val a = {
    Thread.sleep(2000)
    1
  }
  val b = Future {
    Thread.sleep(2000)
    1
  }
  println(a)
  println(b)
  var c: Future[Any] = Future.successful[Any](())
}


object rrs extends App {
  val str = for {
    a <- 1 to 10
  } yield {
    a * 2
  }
  println(str)

  for {
    a <- 1 to 3
    b <- 1 to 10
    if a != b
  }
    println(a * 10 + b + "")


  def encod(s: String, a: String = "<", b: String = ">") = a + s + b

  println(encod("hello"))
  println(encod("--", "xixi"))

  //  @tailrec
  def xx(a: Int*): Unit = {
    var len = a.length
    for (i <- a) {
      println(i)
      len -= 1
    }
    if (len > 0)
      xx()
  }

  xx(1, 2, 3, 4, 5, 6, 7)


  def sum(args: Int*): Int = {
    var res = 0
    for (arg <- args) res += arg
    res
  }

  val s: Int = sum(1, 23, 4, 5)
  println(s)
}

object hosts extends App {
  val hosts = System.getProperty("user.home")
  println(hosts)

  val map: Map[String, String] = Map("a" -> "1", "b" -> "2")


  val a = map.map(createFiled).mkString
  println(a)

  private def createFiled(content: (String, String)): String = content match {
    case (key, value) =>
      s"$key:[$value]"

  }

  val list = List(1, 2, 3)
  val aaa = list./:(0)((sum, i) => sum + i - sum / sum)
  println(aaa)

}

object sad extends App{
  val n1 = 10.111
  val n2 = 10.101
  println(n1-n2)
  val b1 = new BigDecimal("1.111")
  val b2 = new BigDecimal("1.101")
  println("2:%f".format(b1.subtract(b2)))
  val brr = num(new BigDecimal("10.1"),new BigDecimal("10.1"))
  println("3:%d"+ brr.b1.subtract(brr.b2))

}

case class num(b1:BigDecimal,b2:BigDecimal)


object tt {

  def apply(): Unit = {
    println("pp")
  }
}

object aass extends App{
  val a = tt
  a
}


class CompanionDemo {

  println("new CompanionDemo clz")

  def init(): Unit = {
    CompanionDemo.prt()
  }

}

object CompanionDemo {

  println("new CompanionDemo object")

  def prt(): Unit = {
    println("调用了obj")
  }

}
object cpDemp {

  def main(args: Array[String]){

    val cd = new CompanionDemo()
    cd.init()

  }

}
package cn.felord.datetime.convert

import java.util.regex.Pattern

import scala.xml.XML

class ParseXML {


}

object test extends App {
  val someXml = XML.loadFile("G:\\xml\\name.xml")
  val headerName = someXml \ "header" \ "field"
  val field = someXml \\ "field"
  val fieldAttributes = (someXml \ "header" \ "field").map(_ \ "@name")
  val c = (someXml \ "header" \ "field").map(e => (e \ "@name", e \ "@required"))
  // n.text是标签中间的值Test <field name="MsgType" required="Y">Test</field>
  val d = (someXml \ "header" \ "field").map(n => (n \ "@name", n.text, n \ "@required"))
  println(c)
  println(d)
  val e = (someXml \\ "message").filter(_.attribute("name").exists(_.text.eq("Logon")))
  val resultXml1 = (someXml \\ "message").filter(_.attribute("name").exists(_.text.equals("Logon")))
  //  println(someXml)
  //  println(headerName)
  //  println(field)
  //  println(fieldAttributes)
}


object ensuring extends App {

  try {
    val a = 1 + 1
    a.ensuring(e => e < 1, "hhhh")
    println("条件成立")
  } catch {
    case a:AssertionError =>
      "ensuring中条件不成立,抛出异常"
  }



}


object eew extends App{
  val regNum = "[0-9]"
  val pa = Pattern.compile(regNum)
  val num = pa.matcher("sdfdsf61sd6a5f654f1321sdaf6")
  println("num = " + num)
  val mNum = num.matches()
  println(mNum)
}
package cn.felord.datetime.convert.util

import java.text.SimpleDateFormat
import java.util.Date

/**
  * 日期时间
  *
  * @param date 日期
  * @param time 时间
  */
case class DateTime(date: String, time: String)


/**
  * 日期时间工具
  */
object DateTime {
  /**
    * 返回标准的日期时间格式
    *
    * @return 其中日期为yyyyMMdd, 时间为HHmmss
    */
  def standard(): DateTime = {
    custom("yyyyMMddHHmmss", 8)
  }

  /**
    * 自定义日期格式分割
    *
    * @param style    样式
    * @param splitPos 分割位置
    * @return
    */
  def custom(style: String, splitPos: Int): DateTime = {
    val str = new SimpleDateFormat(style).format(new Date)
    val d = str.take(splitPos).trim
    val t = str.drop(splitPos).trim
    DateTime(d, t)
  }
}

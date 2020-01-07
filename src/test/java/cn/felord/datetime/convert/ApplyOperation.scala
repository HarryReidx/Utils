package cn.felord.datetime.convert

class ApplyOperation {
""
}

class ApplyTest {
  def apply(b: String): Unit = println(b + ":I am into spark so much!!!")

  def haveATry: Unit = {
    println("have a try on apply")
  }
}

object ApplyTest {
  def apply(i: Int): ApplyTest = {
    println(i.toString + ":I  am into Scala so much")
    new ApplyTest
  }
}

object ApplyOperation {
  def main(args: Array[String]) {
    val array = Array(1, 2, 3, 4)
    val a = ApplyTest(111) //这里就是使用object 的使用
    val b = ApplyTest.apply(222)

    a.haveATry
    a("AAA") // 这里就是 class 中 apply使用
    b.apply("BBB")
    new ApplyTest
    new ApplyTest()
    (new ApplyTest).apply("CCC")
    // ApplyTest("DDD")--error   object的apply方法参数是Int类型
    //    new ApplyTest(555)--error  class的apply方法不是构造方法
    ApplyTest(333)
    ApplyTest.apply(444)
  }
}


object cca {
  def apply(a: String): Unit = {
    println(a + ",来了")
  }
}

object asasa extends App {
  cca("马上")
}

class Person(name: String,
             age: Int,
             sex: String
            ) {
}

object Person {
  def pl(list:List[Person]): Unit ={
    list.map({
      e =>
        s"""<node>
          |
          """.stripMargin
    })
  }

}

  object aaa extends App {
    println("============")
//    person("张三", 10, "男")
    println("+++++==========")

  }
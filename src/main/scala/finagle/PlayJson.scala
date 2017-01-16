package finagle

/**
  * Created by hendisantika on 10/01/17.
  */
import play.api.libs.json._

object PlayJson extends App{

implicit val modelFormat = Json.format[Model]

  val rawJson = """{"hello": "world", "age": 42}"""
  val res1 = Json.parse(rawJson)

  val res0 = (res1 \ "hello").as[String]

  println("res0 --> " + res0)
  println("res1 --> " + res1)

  val res2 = Json.obj("hello" -> "world", "age" -> 42)

  println("res2 -->" + res2)

  val res3 = Json.fromJson[Model](res2)
  val res4 = res3.get

  val res5 = Json.toJson(Model("bar", 23))

  println("res3 --> " + res3)
  println("res5 --> " + res5)
}

case class Model(hello: String, age: Int)



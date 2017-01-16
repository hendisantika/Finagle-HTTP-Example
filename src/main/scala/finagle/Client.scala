package finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}
import io.circe.Json
import io.circe.parser.parse
import io.circe.Json
import io.circe.parser._
import cats.syntax.either._
import io.circe.optics.JsonPath._
import io.circe.syntax._
import io.circe._
import io.circe.generic.semiauto._


/**
  * Created by hendisantika on 28/12/16.
  * sbt 'run-main Client'
  *
  * GET success: Response("HTTP/1.1 Status(200)")
  */
object Client extends App {
  val httpClient: Service[http.Request, http.Response] = Http.newService("10.2.15.5:8983")
  val keyword = "ibadah"
  val artId = 9528716
  val limit = 2
  val offset = 0

//  val request = http.Request(http.Method.Get, "/solr/interaction-repo/select?q=content_t%3A" + keyword + "%26%26%0A" +
//    "article_id_l%3A+" + artId + "%0A%0A&sort=comment_id_l+desc%0A%0A&start=" + offset + "&rows=" + limit + "&wt=json&indent=true")

  val request = http.Request(http.Method.Get, "/solr/interaction-repo/select?q=article_id_l:10170502&start=0&rows=2&wt=json&indent=true")

  request.host = "10.2.15.5"

  val response: Future[http.Response] = httpClient(request)
  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)
    val content = rep.contentString
        println("GET content: \n" + content)
    //    val json: Json = parse(content).getOrElse(Json.Null)
    //    val _phoneNum = root.order.customer.contactDetails.phone.string
    //    content.as[List[String]]

    //    println("Tes -->" + content)
//    val rawJson: String = content
//    println("Hasilnya " + rawJson)

//    val json: Json = parse(rawJson).getOrElse(Json.Null)
//    val json: Json = parse(content).getOrElse(Json.Null)
//    val _id = root.order.customer.contactDetails.phone.string
//    val _id = root.response.docs.id.string
//
//    val id: Option[String] = _id.getOption(json)
//    println("id: " + id)

//    implicit val comDecoder: Decoder[SolrDoc] = deriveDecoder[SolrDoc]
//
//    val obj = decode[SolrDoc](content) match {
//      case Left(failure) => println("Gagal --> " + failure)
//      case Right(com) => println("OK")
//        println("Ada  nich ...")
//        println(com)
//    }


//    val parseResult = parse(rawJson)
//    match {
//      case Left(failure) => println("Invalid JSON :(")
//      case Right(json) => println("Ada JSON euy!")
//    }
//
//    println("parseResult" + parseResult)


  })


}

package finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}
import io.circe.parser.decode
import cats.data

/**
  * Created by hendisantika on 28/12/16.
  * sbt 'run-main Client'
  *
  * GET success: Response("HTTP/1.1 Status(200)")
  */
object Client2 extends App{
  val client: Service[http.Request, http.Response] = Http.newService("http://10.2.15.5:8983/solr/interaction-repo/select?q=content_t%3Aibadah+%26%26%0Aarticle_id_l%3A6729941&wt=json&indent=true")
  val request = http.Request(http.Method.Get, "/")
  request.host = "http://10.2.15.5"
  val response: Future[http.Response] = client(request)
  Await.result(response.onSuccess { rep: http.Response =>
    println("GET success: " + rep)

//    val obj = decode[SolrDoc](rep.contentString)
//    val solrDocument = obj match {
//      case Xor.Right(r) => r
//      case Xor.Left(l) => "document not found"
//    }

  })
}

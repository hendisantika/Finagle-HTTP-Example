package finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

/**
  * Created by hendisantika on 16/01/17.
  * sbt 'run-main Client'
  *
  * GET success: Response("HTTP/1.1 Status(200)")
  */
object Client3 extends App{
  val client: Service[http.Request, http.Response] = Http.newService("https://jsonplaceholder.typicode.com:80/posts/1")
  val request = http.Request(http.Method.Get, "/")
//  request.host = "https://jsonplaceholder.typicode.com"
  request.host = "104.31.87.157"
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

package finagle

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

/**
  * Created by hendisantika on 16/01/17.
  * sbt 'run-main Client'
  *
  * GET success: Response("HTTP/1.1 Status(200)")
  */
object Client3 extends App {
  val client: Service[http.Request, http.Response] = Http.newService("https://jsonplaceholder.typicode.com:80")
  val request = http.Request(http.Method.Get, "/posts")
  request.host = "https://104.31.86.157"
  val response: Future[http.Response] = client(request)
    Await.result(response.onSuccess { rep: http.Response =>
      println("GET success: " + rep)

  //    val obj = decode[SolrDoc](rep.contentString)
  //    val solrDocument = obj match {
  //      case Xor.Right(r) => r
  //      case Xor.Left(l) => "document not found"
  //    }

    })
//  val hit = Future {
//    response.onSuccess { rep: http.Response =>
//      println("GET success: " + rep)
//      println("GET Content: " + rep.contentString)
//
//    }
//  }

//  hit onSuccess (_ => println("content --> " + rep ))

}




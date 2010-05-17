package unfiltered.demo

import unfiltered.request._
import unfiltered.response._

object AId extends scala.util.matching.Regex("""/a/(\d+)""")

object Demo {
  def print(message: String) = Html(
    <html><body> { message } </body></html>
  )
}

class Demo extends unfiltered.Handler ({
  case GET(Path("/", req)) => Demo.print("hello world")
  case GET(Path(AId(id), req)) => Demo.print(id)
  case GET(Path(Seg("b", id), req)) => Demo.print(id)
})

object DemoServer {
  def main(args: Array[String]) {
    unfiltered.server.Http(8080)(new Demo)
  }
}
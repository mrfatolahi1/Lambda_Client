//import requests.{Request, Response}
//
//object Server extends cask.MainRoutes{
//  @cask.get("/")
//  def hello(): String = {
//    "hello world! \n" +
//      "salam!"
//  }
//
//  @cask.post("/do-thing")
//  def doThing(request: cask.Request): String = {
//    new String(request.readAllBytes()).reverse
//  }
//
//  initialize()
////  def main(args: Array[String]): Unit = {
////    val r: Response = requests.get("https://api.github.com/users/baeldung")
////    val responseText = r.text
////    print(responseText)
////    assert(responseText.contains("http://www.baeldung.com"))
////    assert(r.statusCode == 200)
////    assert(r.contentType.exists(_.contains("application/json")))
////  }
//}

import controllers.MainController

object Main {
  def main(args: Array[String]): Unit = {
    val mainController: MainController = new MainController
    mainController.operate()
  }
}

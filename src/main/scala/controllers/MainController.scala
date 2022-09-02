package controllers
import readers.Reader
import senders.Sender

class MainController extends Controller {
  override val reader: Reader = null
  override val sender: Sender = null
  val userActivityController: UserActivityController = new UserActivityController

  override def operate(): Unit = {
    userActivityController.operate()
  }
}

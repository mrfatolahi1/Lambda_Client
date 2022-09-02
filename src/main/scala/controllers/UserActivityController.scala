package controllers
import readers.UserActivityReader
import senders.UserActivitySender

import java.time.{Duration, LocalDateTime}
import java.util

class UserActivityController extends Controller {
  override val reader: UserActivityReader = new UserActivityReader
  override val sender: UserActivitySender = new UserActivitySender
  var timeScale: Double = 100
  val eventQueue: util.Queue[String] = new util.LinkedList()
  var currentEvent: String = _
  var nextEvent: String = _

  override def operate(): Unit = {
    this.initializeQueue(101)
    this.nextEvent = eventQueue.poll()
    while (true) {
      this.currentEvent = nextEvent
      sender.send("topicA", currentEvent)
      this.nextEvent = eventQueue.poll()
      eventQueue.add(reader.read())
//      println("-----------------------------------------------")
//      println("CUR: " + currentEvent)
//      println("NEX: " + nextEvent)
//      println("-----------------------------------------------")
      val duration: Duration = Duration.between(
        LocalDateTime.parse(ujson.read(currentEvent)("time").str),
        LocalDateTime.parse(ujson.read(nextEvent)("time").str)
      )
      Thread.sleep(duration.getSeconds.*(timeScale).toLong)
    }
  }

  def initializeQueue(numberOfInitObjects: Int): Unit = {
    for (_ <- 1 to numberOfInitObjects){
      this.eventQueue.add(reader.read())
    }
  }
}

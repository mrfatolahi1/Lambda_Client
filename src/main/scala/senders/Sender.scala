package senders

abstract class Sender {
  def send(topic:String, data: String): Unit
}

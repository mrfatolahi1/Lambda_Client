package controllers

import readers.Reader
import senders.Sender

abstract class Controller {
  val reader: Reader
  val sender: Sender
  def operate(): Unit
}

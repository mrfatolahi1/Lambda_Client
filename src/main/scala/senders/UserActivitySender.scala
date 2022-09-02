package senders

import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerConfig, ProducerRecord}

import java.time.LocalDateTime
import java.util.Properties

class UserActivitySender extends Sender {
  val properties = new Properties()

  properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  properties.put(ProducerConfig.ACKS_CONFIG, "all")
  properties.put(ProducerConfig.CLIENT_ID_CONFIG, "WebLogProducer")

  val kafkaProducer: Producer[Nothing, String] = new KafkaProducer[Nothing, String](properties)

  override def send(topic:String = "topicA", data: String): Unit = {
    println(data)
    val producerRecord = new ProducerRecord(topic, data)
    this.kafkaProducer.send(producerRecord)
    println(s"sent:   $data   in   ${LocalDateTime.now()}")
  }
}

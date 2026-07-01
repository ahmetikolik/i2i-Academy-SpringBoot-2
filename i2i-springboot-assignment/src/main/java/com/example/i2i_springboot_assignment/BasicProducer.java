package com.example.i2i_springboot_assignment;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicProducer {

  public static final String TOPIC = "hello-world-topic";

  public static void main(String[] args) {
    System.out.println("*** Starting Custom Object Producer ***");

    Properties settings = new Properties();
    settings.put("client.id", "basic-producer");
    settings.put("bootstrap.servers", "35.184.7.162:9092");
    settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    // Nesneleri JSON'a çevirecek olan araç
    ObjectMapper objectMapper = new ObjectMapper();

    try (KafkaProducer<String, String> producer = new KafkaProducer<>(settings)) {
      for (int i = 1; i <= 3; i++) {
        // 1. Kendi nesnemizi üretiyoruz
        Assignment assignment = new Assignment(i, "EDA With Apache Kafka", "Student-" + i);

        // 2. Nesneyi JSON (String) formatına dönüştürüyoruz (Serialization)
        String jsonValue = objectMapper.writeValueAsString(assignment);

        final String key = "key-" + i;
        System.out.println("### Sending Object: " + assignment.toString() + " ###");

        // Kafka'ya JSON string'ini gönderiyoruz
        producer.send(new ProducerRecord<>(TOPIC, key, jsonValue));
      }
    } catch (Exception e) {
        System.err.println("Hata oluştu: " + e.getMessage());
    }
    System.out.println("*** Producer Finished ***");
  }
}
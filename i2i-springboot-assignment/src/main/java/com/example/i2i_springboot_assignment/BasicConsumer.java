package com.example.i2i_springboot_assignment;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicConsumer {
    public static void main(String[] args) {
        System.out.println("*** Starting Custom Object Consumer ***");

        Properties settings = new Properties();
        settings.put("bootstrap.servers", "35.184.7.162:9092");
        settings.put("group.id", "i2i-assignment-group");
        settings.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        settings.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        settings.put("auto.offset.reset", "earliest");

        ObjectMapper objectMapper = new ObjectMapper();

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(settings)) {
            consumer.subscribe(Collections.singletonList(BasicProducer.TOPIC));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    try {
                        // 1. Kafka'dan gelen ham JSON String'ini alıyoruz
                        String jsonValue = record.value();

                        // 2. JSON'ı tekrar Java Nesnesine map ediyoruz (Deserialization)
                        Assignment incomingAssignment = objectMapper.readValue(jsonValue, Assignment.class);

                        // 3. Ekrana nesnemizi bastırıyoruz
                        System.out.println("KAFKA'DAN OBJEMİZ GELDİ -> " + incomingAssignment);
                        
                    } catch (Exception e) {
                        System.err.println("Mesaj parse edilirken hata: " + e.getMessage());
                    }
                }
            }
        }
    }
}
Markdown
This repository contains a simple Spring Boot application developed. The project demonstrates core backend concepts, event-driven communication using Apache Kafka, cloud deployment on Google Cloud Platform (GCP), and containerization using Docker.

🚀 Features
* **Spring Boot Backend:** A lightweight application built with Java 17.
* **Event-Driven Architecture:** Asynchronous message processing implemented via Apache Kafka with custom structured object serialization.
* **GCP Cloud Deployment:** Hosted on a Google Cloud Compute Engine (Ubuntu VM).
* **Dockerization:** Fully containerized application and message broker infrastructure for environment-independent deployment.
* **Monitoring:** Resource usage tracked natively via Docker stats.

🛠️ Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3.3.4
* **Message Broker:** Apache Kafka (v4.3.1)
* **Build Tool:** Maven
* **Infrastructure:** Google Cloud Platform (GCP)
* **Containerization:** Docker & Docker Compose (Base Image: eclipse-temurin:17-jdk-jammy)

📦 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd i2i-springboot-assignment
Start the Apache Kafka Broker:
Ensure Docker is running on your machine, then launch the Kafka container:

Bash
docker run -d --name my-kafka -p 9092:9092 apache/kafka:4.3.1
Build the Application:
Package the application using Maven to generate the executable JAR file:

Bash
mvn clean package
Run the Microservice Components:
Use Spring's PropertiesLauncher to run the specific producer and consumer execution flows independently:

Start the Consumer:

Bash
java -cp target/i2i-springboot-assignment-0.0.1-SNAPSHOT.jar -Dloader.main=com.example.i2i_springboot_assignment.BasicConsumer -Dbootstrap.servers=localhost:9092 org.springframework.boot.loader.launch.PropertiesLauncher
Start the Producer:

Bash
java -cp target/i2i-springboot-assignment-0.0.1-SNAPSHOT.jar -Dloader.main=com.example.i2i_springboot_assignment.BasicProducer -Dbootstrap.servers=localhost:9092 org.springframework.boot.loader.launch.PropertiesLauncher

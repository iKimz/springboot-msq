# Spring Boot with RabbitMQ
* [RabbitMQ](https://www.rabbitmq.com/)
* [Spring Boot + Spring AMQP](https://spring.io/projects/spring-amqp)

## Steps

### Step 1. Start [RabbitMQ server]
docker compose up -d

### Step 2. Start producer
```
$cd producer
$./mvnw spring-boot:run
```

### Step 3. Start consumer
```
$cd consumer
$./mvnw spring-boot:run
```

### Step 4. Testing
Call api with url= http://localhost:8080/message/pushMsg
 

package az.company.springbootkafkaexample.controller;

import az.company.springbootkafkaexample.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    //docker exec -it {kafka container name} kafka-console-consumer --bootstrap-server {kafka server port} --topic {topic name} --from-beginning
    //docker exec -it kafka kafka-console-consumer --bootstrap-server localhost:9092 --topic myTopic --from-beginning


    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic successfully");
    }


}

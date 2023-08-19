package az.company.springbootkafkaexample.controller;

import az.company.springbootkafkaexample.kafka.producer.JsonKafkaProducer;
import az.company.springbootkafkaexample.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;




    @PostMapping("/publish")
    public ResponseEntity<String> publishUser(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to topic successfully");
    }


}

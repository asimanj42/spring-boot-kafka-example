package az.company.springbootkafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String myTopic;

    @Value("${spring.kafka.json-topic.name}")
    private String myJsonTopic;

    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name(myTopic)
                .build();
    }

    @Bean
    public NewTopic myJsonTopic() {
        return TopicBuilder.name(myJsonTopic)
                .build();
    }
}

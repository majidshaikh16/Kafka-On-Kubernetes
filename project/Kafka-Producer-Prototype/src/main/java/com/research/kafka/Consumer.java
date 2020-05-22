package com.research.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Majid
 *
 */
@Component
public class Consumer {


//	@KafkaListener(topics = "#{'${spring.kafka.consumer.topic.name}'.split(',')}", containerFactory = "kafkaListenerContainerFactory")
//	public void consume(List<ConsumerRecord<String, byte[]>> messages) {
////		messages.stream().filter(Objects::nonNull).forEach(partialService::process);
//	}

}

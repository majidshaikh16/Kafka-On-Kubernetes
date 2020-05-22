package com.research.kafka;

import java.util.List;
import java.util.Objects;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.research.service.OrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Majid
 *
 */
@Slf4j
@Component
public class Consumer {

	@Autowired
	private OrderService orderService;

	@KafkaListener(topics = "#{'${spring.kafka.consumer.topic.name}'.split(',')}", containerFactory = "kafkaListenerContainerFactory")
	public void consume(List<ConsumerRecord<String, byte[]>> messages) {
		messages.parallelStream().filter(Objects::nonNull).forEach(m -> {
			orderService.createNewOrder(m.value(), m.key());
		});
	}

}

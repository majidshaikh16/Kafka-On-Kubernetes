package com.research.controller;

import static com.research.util.ObjectMapper.objectToBytes;

import java.util.UUID;

import javax.validation.Valid;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.dto.Order;
import com.research.kafka.Producer;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author majid
 *
 */
@Slf4j
@RestController
@RequestMapping(path = "/order")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private Producer producer;

	@PostMapping(path = "/new")
	public String newOrder(@RequestBody @Valid Order order) {
		String uuid = UUID.randomUUID().toString();
		order.setUuid(uuid);
		log.info("Received a new order {} uuid {}", order, uuid);
		byte[] orderBytes = objectToBytes(order);
		ProducerRecord<String, byte[]> publishResponse = producer.publishResponse(orderBytes, 0, uuid);
		producer.sendMessage(publishResponse);
		return "Your order is accepted and sent for cooking!";
	}

}

package com.research.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Majid
 *
 */
@Service
@Slf4j
public class Producer {

	@Value("${spring.kafka.producer.topic.name}")
	private String topic;

	@Value("${spring.kafka.max-partition}")
	private int maxPartition;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaTemplate<String, byte[]> kafkaTemplate;

	public ProducerRecord<String, byte[]> publishResponse(String payload, int partition, String msgKey) {
		return new ProducerRecord<>(topic, partition, msgKey, payload.getBytes());

	}
	public ProducerRecord<String, byte[]> publishResponse(byte[] payload, int partition, String msgKey) {
		return new ProducerRecord<>(topic, partition, msgKey, payload);

	}

	public void sendMessage(ProducerRecord<String, byte[]> message) {

		ListenableFuture<SendResult<String, byte[]>> future = kafkaTemplate.send(message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, byte[]>>() {

			@Override
			public void onSuccess(SendResult<String, byte[]> result) {
				logger.info("Request UUID [{}] Sent message [{}]", Thread.currentThread().getName(), message);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Request UUID [{}] Unable to send message with error [{}]",
						Thread.currentThread().getName(), ex.getMessage());
			}
		});
	}

}

package com.research.kafka;
//package com.research.kafka;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//import com.research.util.Diameter.HaudWrapper;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author Majid
// *
// */
//@Service
//@Slf4j
//public class Producer {
//
//	@Value("${spring.kafka.producer.topic.name}")
//	private String topic;
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private KafkaTemplate<String, byte[]> kafkaTemplate;
//
//	
//
//	public void sendMessage(HaudWrapper message, int partition, String messageKey) {
//		sendMessage(publishResponse(message, partition, messageKey));
//	}
//
//	public ProducerRecord<String, byte[]> publishResponse(HaudWrapper diameterWrapper, int partition, String msgKey) {
////		logger.info("Request UUID [{}] publish Response for msgKey [{}] in partition [{}]",
////				Thread.currentThread().getName(), msgKey, partition);
//
//		return new ProducerRecord<>(topic, partition, msgKey, diameterWrapper.toByteArray());
//
//	}
//	
//	public void sendMessage(ProducerRecord<String, byte[]> message) {
//
//		ListenableFuture<SendResult<String, byte[]>> future = kafkaTemplate.send(message);
////		StatisticsManager.getInstance().setPktSentToKafkaTime();
//		future.addCallback(new ListenableFutureCallback<SendResult<String, byte[]>>() {
//
//			@Override
//			public void onSuccess(SendResult<String, byte[]> result) {
//				com.research.util.Constant.KAFK_REQ_PER_SEC.incrementAndGet();
////				logger.info("Request UUID [{}] Sent message [{}]", Thread.currentThread().getName(), message);
////				StatisticsManager.getInstance().setPktSentTime();
//			}
//
//			@Override
//			public void onFailure(Throwable ex) {
//				logger.error("Request UUID [{}] Unable to send message with error [{}]",
//						Thread.currentThread().getName(), ex.getMessage());
//			}
//		});
//	}
//	
//}

package com.example.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		 LOG.info(String.format("Message sent : %s", message));
	     kafkaTemplate.send(topicName, message);
	}
}

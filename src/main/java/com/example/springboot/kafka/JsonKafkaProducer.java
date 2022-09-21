package com.example.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.springboot.payload.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;
	
	JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate){
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) {
		LOG.info(String.format("Message sent: %s ", user.toString()));
		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "jsontopic").build();
		kafkaTemplate.send(message);
	}
}

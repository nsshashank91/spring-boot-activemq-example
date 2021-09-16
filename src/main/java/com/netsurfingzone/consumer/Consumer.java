package com.netsurfingzone.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "netsurfingzone-queue")
	public void consumeMessage(String message) throws IOException {
		logger.info("Message received from activemq queue---"+message);
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(message, Student.class);
		logger.info(student.toString());

	}
}

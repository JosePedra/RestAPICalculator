package com.javachallenge.calculator;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.javachallenge.calculator.MQConfig.QUEUE;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(CalculatorApplication.class, args);

		final ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");

		try (final Connection connection = connectionFactory.newConnection();
			 final Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE, false, false, false, null);

			for (int i = 1; i < 11; i++) {
				final String message = "Hello world= " + i;
				System.out.println("Sending the following message to the queue: " + message);
				channel.basicPublish("", QUEUE, null, message.getBytes("UTF-8"));
			}
		}
	}

}

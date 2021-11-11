package com.javachallenge.backend;

import module.Calculator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private final Calculator calculator;

    public MessageListener() {
        calculator = new Calculator();
    }

    @RabbitListener(queues = MQConfig.QUEUE)
    public String calculate(Message message) {
        try {
            return (calculator.calculate(message.getA(), message.getB(), message.getOperation())).toString();
        } catch (Exception e) {
            return "[ERROR]";
        }
    }
}

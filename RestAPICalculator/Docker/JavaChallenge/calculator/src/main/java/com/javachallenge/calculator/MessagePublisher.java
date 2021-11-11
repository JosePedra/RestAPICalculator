package com.javachallenge.calculator;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/sum")
    public String sum(@RequestBody Message message) {
        message.setOperation(Message.SUM);
        return (String) template.convertSendAndReceive(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }

    @PostMapping("/subtract")
    public String subtract(@RequestBody Message message) {
        message.setOperation(Message.SUBTRACTION);
        return (String) template.convertSendAndReceive(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }

    @PostMapping("/multiply")
    public String multiply(@RequestBody Message message) {
        message.setOperation(Message.MULTIPLICATION);
        return (String) template.convertSendAndReceive(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }

    @PostMapping("/divide")
    public String divide(@RequestBody Message message) {
        message.setOperation(Message.DIVISION);
        return (String) template.convertSendAndReceive(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }
}

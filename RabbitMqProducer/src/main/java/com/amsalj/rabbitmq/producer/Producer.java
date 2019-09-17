package com.amsalj.rabbitmq.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class Producer {
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value ("${amsalj.rabbitmq.exchange}")
    private String exchange;
    @Value ("${amsalj.rabbitmq.routingkey}")
    private String routingKey;
    @Value ("${amsalj.rabbitmq.queue}")
    private String queueName;

    public void produceMsg(String msg){
        rabbitTemplate.convertAndSend (exchange,routingKey,msg);
        System.out.println ("Send msg: "+msg);
    }


}

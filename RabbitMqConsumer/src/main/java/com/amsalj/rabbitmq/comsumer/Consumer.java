package com.amsalj.rabbitmq.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "${amsalj.rabbitmq.queue}")
    public void receiveMsg(String msg){
        System.out.println ("Receive Message: "+msg);
    }
}

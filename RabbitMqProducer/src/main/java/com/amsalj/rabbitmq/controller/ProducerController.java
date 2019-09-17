package com.amsalj.rabbitmq.controller;

import com.amsalj.rabbitmq.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private Producer producer;
    @Autowired
    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping(value = "/send")
    public String sendMsg(@RequestParam("msg") String msg){
        producer.produceMsg (msg);
        return "Done";
    }
}

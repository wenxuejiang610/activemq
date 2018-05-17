package com.demo.springJms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;

public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Destination destination;


    @Override
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, session -> session.createTextMessage(message));
        System.out.println("发送消息" + message);
    }


}

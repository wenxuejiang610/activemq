package com.demo.jms.topic;

import com.demo.jms.util.AppUtil;

import javax.jms.*;

public class AppConsumer {
    //队列的名字
    public static final String topicName = "topic-test";

    public static void main(String[] args) throws JMSException {
        Connection connection = AppUtil.getConnectionConsumer();

        //4.创建会话(第一个参数代表事物，自动应答)
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //5.创建一个目标
        Destination destination = session.createTopic(topicName);

        //6.创建生产者
        MessageConsumer consumer = session.createConsumer(destination);

        //7.创建一个监听器
        consumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("接收消息" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

    }

}

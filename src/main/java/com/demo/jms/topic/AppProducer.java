package com.demo.jms.queue;

import com.demo.jms.util.AppUtil;

import javax.jms.*;

public class AppProducer {
    //队列的名字
    public static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        Connection connection = AppUtil.getConnection();
        //4.创建会话(第一个参数代表事物，自动应答)
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //5.创建一个目标
        Destination destination = session.createQueue(queueName);

        //6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for(int i = 0 ; i < 100 ; i++){
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            //8.发布消息
            producer.send(textMessage);

            System.out.println("test" + i + "发送成功");
        }

        //9.关闭连接
        connection.close();
    }

}

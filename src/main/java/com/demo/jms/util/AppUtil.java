package com.demo.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

public class AppUtil {
    //61616是activemq的默认端口
    private static final String url = "tcp://127.0.0.1:61616";


    public static Connection getConnection() throws JMSException {
        //1.根据连接创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2.创建Connection
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        return  connection;
    }
}

package com.demo.jms.util;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;


//不推荐，这种做法依然会建立新的连接，使用static静态块也不好，无法抛出异常到上层
//推荐使用链接池
public class AppUtil {
    private static final String url = "failover:(tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
    private static final String url2 = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";

    public static Connection getConnectionProductor() throws JMSException {
        //1.根据连接创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        //2.创建Connection
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        return  connection;
    }

    public static Connection getConnectionConsumer() throws JMSException {
        //1.根据连接创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url2);

        //2.创建Connection
        Connection connection = connectionFactory.createConnection();

        //3.启动连接
        connection.start();

        return  connection;
    }
}

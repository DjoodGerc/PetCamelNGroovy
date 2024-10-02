package org.example.camel;

import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class CamelConfig {
//    public static final String RABBIT_URI="rabbitmq:amq.direct?queue=mySnd&routingKey=routing_key&autoDelete=false&connectionFactory=rabbitConnectionFactory";

    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("goose.rmq2.cloudamqp.com");
        factory.setVirtualHost("tsnxhbnp");
        factory.setUsername("tsnxhbnp");
        factory.setPassword("7JHxx4gjG5v4iMci6qvZnqtPGOJNoHB2");
//        factory.
//        factory.setPort(1883);
        return factory;
    }
}
//@Configuration
//@RequiredArgsConstructor
//public class CamelConfig {
//
//    private final CachingConnectionFactory rabbitConnectionFactory;
//
//    @Bean
//    com.rabbitmq.client.ConnectionFactory rabbitSourceConnectionFactory() {
//        return rabbitConnectionFactory.getRabbitConnectionFactory();
//    }
//}
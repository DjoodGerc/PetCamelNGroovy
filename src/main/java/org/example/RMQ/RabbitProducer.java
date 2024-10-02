package org.example.RMQ;

//import org.apache.camel.Produce;
//import org.apache.camel.ProducerTemplate;
import com.rabbitmq.client.ConnectionFactory;
import org.example.StudentPojo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    @Autowired
    private RabbitTemplate template;


    public void sendJson(StudentPojo student) throws InterruptedException {
        String exchange = "myEx";
        String routingKey = "routing_key";

        template.convertAndSend(exchange, routingKey,student);




    }

}

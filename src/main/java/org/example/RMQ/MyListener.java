package org.example.RMQ;

import org.example.StudentPojo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableRabbit
public class MyListener {

//        @RabbitListener(queues = "mySnd")
//        public void mySndListener(@Payload StudentPojo studentPojo) throws IOException {
//            studentPojo.rabbitId+=1;
//            System.out.println("recieved from RMQ{");
//            System.out.println(studentPojo);
//            System.out.println("}\n");
//
//
//        }

        @RabbitListener(queues = "myQu")
        public void myQuListener(@Payload StudentPojo studentPojo) throws IOException {
//            studentPojo=new StudentPojo();
            studentPojo.rabbitId+=1;
            System.out.println("recieved from RMQ{");
            System.out.println(studentPojo);
            System.out.println("}\n");


        }
    }
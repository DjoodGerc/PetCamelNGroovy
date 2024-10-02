package org.example;

import org.example.RMQ.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    RabbitProducer rabbitProducer;

    public void toRabbit(StudentPojo student) throws InterruptedException {
        student.rabbitId+=1;
        rabbitProducer.sendJson(student);
        System.out.println("Sent to RMQ without camel{");
        System.out.println(student.toString());
        System.out.println("}");
        Thread.sleep(5000);
    }

}

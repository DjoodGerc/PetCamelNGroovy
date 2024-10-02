package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyService myService;
    @Produce("direct:restGetStudent")
    ProducerTemplate producerTemplate;

    @GetMapping(value = "student/{studentName}")
    public StudentPojo getTestData(@PathVariable(value = "studentName") String name) throws InterruptedException {
        CamelContext camelContext=new DefaultCamelContext();
        camelContext.start();
        StudentPojo student = new StudentPojo();
        student.restId+=1;
        student.name=name;
        System.out.println("came from controller with REST {");
        System.out.println(student.toString());
        System.out.println("}\n");
        Thread.sleep(5000);
        myService.toRabbit(student);
        producerTemplate.sendBody(student);
        return student;
    }
}

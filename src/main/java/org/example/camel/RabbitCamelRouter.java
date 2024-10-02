package org.example.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.StudentPojo;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import static org.apache.camel.language.groovy.GroovyLanguage.groovy;

@Component
public class RabbitCamelRouter extends RouteBuilder {
    JacksonDataFormat jsonDataFormat=new JacksonDataFormat(StudentPojo.class);
    @Override
    public void configure() throws Exception {
        from("direct:restGetStudent").id("idToStudentRoute")
                .marshal(jsonDataFormat)
                .log("sent to rmq with camel "+body().toString()+" ")
                .to("rabbitmq:myEx?queue=mySnd&routingKey=snd_key&autoDelete=false&connectionFactory=connectionFactory").end();
        ///myEx?queue=mySnd"
    }
}

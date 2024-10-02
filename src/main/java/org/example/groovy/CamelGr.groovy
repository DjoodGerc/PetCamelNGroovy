package org.example.groovy

import com.rabbitmq.client.ConnectionFactory
import groovy.transform.Field
import org.apache.camel.Exchange
import org.apache.camel.Expression
import org.apache.camel.Processor
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jackson.JacksonDataFormat
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.model.dataformat.JsonDataFormat
import org.apache.camel.spi.DataFormat
import org.example.StudentPojo
import org.springframework.context.annotation.Bean

import javax.swing.Spring
jsonDataFormat=new JacksonDataFormat(StudentPojo.class);

factory=new ConnectionFactory();
factory.setHost("goose.rmq2.cloudamqp.com");
factory.setVirtualHost("tsnxhbnp");
factory.setUsername("tsnxhbnp");
factory.setPassword("7JHxx4gjG5v4iMci6qvZnqtPGOJNoHB2");
camelContext=new DefaultCamelContext()
camelContext.start()
jdf=new JsonDataFormat()
Integer a=0;
st=new StudentPojo()

camelContext.addRoutes(new RouteBuilder() {
            void configure() {
                from("timer://jdkTimer?period=3000").
                        process(new Processor() {
            @Override
            void process(Exchange exchange) throws Exception {
                st.name="gr ${a}"
                exchange.getIn().setBody(st)
                a+=1
                println(a)
            }
        }).marshal(jsonDataFormat)
        .log(body() as String)

                .to("rabbitmq:mynn?queue=myQu&routingKey=routing_key&autoDelete=false&hostname=goose.rmq2.cloudamqp.com&vhost=tsnxhbnp&username=tsnxhbnp&password=7JHxx4gjG5v4iMci6qvZnqtPGOJNoHB2&portNumber=5672").end()

    }
})


//addShutdownHook{ camelContext.stop() }
//synchronized(this){ this.wait() }
package com.benjsoft.demo;

import com.benjsoft.demo.models.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamRabbitDemoApplication {

   public static void main(String[] args) {
      SpringApplication.run(SpringCloudStreamRabbitDemoApplication.class, args);
   }

   @StreamListener(Sink.INPUT)
   public void handlerEmployeeRegistration(Employee employee) {
      System.out.println("Received: " + employee);
   }
}

package com.benjsoft.demo.controllers;

import com.benjsoft.demo.models.Employee;
import com.benjsoft.demo.sources.EmployeeRegistrationSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {

   @Autowired
   private EmployeeRegistrationSource employeeRegistrationSource;

   @GetMapping("/register")
   @ResponseBody
   public String registerEmployee(@RequestBody Employee employee) {
      this.employeeRegistrationSource.publishEmployeeRegistration().send(MessageBuilder.withPayload(employee).build());
      System.out.println("Employee Registration: " + employee.toString());
      return "Employee published for registration";
   }
}

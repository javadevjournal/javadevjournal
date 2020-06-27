package com.javadevjournal.springbootbatch.model;

import lombok.Data;

@Data
public class Employee {
  private String firstName;
  private String lastName;
  private String department;

  public Employee() {    
  }
}

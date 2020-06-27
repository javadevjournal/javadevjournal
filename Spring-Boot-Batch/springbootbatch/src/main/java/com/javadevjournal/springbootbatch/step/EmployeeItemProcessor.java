package com.javadevjournal.springbootbatch.step;

import com.javadevjournal.springbootbatch.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor
    implements ItemProcessor<Employee, String> {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(EmployeeItemProcessor.class);

  @Override
  public String process(Employee employee) throws Exception {
    String greeting = "Hello " + employee.getFirstName() + " "
        + employee.getLastName() + " from " + employee.getDepartment()+"!";

    LOGGER.info("converting '{}' into '{}'", employee, greeting);
    return greeting;
  }
}

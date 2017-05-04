package com.lc475;

import com.lc475.model.Days;
import com.lc475.model.Employee;
import com.lc475.model.ShiftTime;
import com.lc475.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * CommandLinerRunner:
 *  After the application, all rh beans and the application context is created
 *  all classes that implement this interface are executed
 *  This is ideal to initialise things in an application
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private EmployeeRepository employeeRepository;

    //dependency injection
    @Autowired
    public DatabaseSeeder(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("leo","con", Days.Monday, ShiftTime.Day));
        employeeList.add(new Employee("costis","con",Days.Tuesday,ShiftTime.Evening));
        employeeList.add(new Employee("mixas","con",Days.Wednesday,ShiftTime.Night));


        employeeRepository.save(employeeList);

    }
}

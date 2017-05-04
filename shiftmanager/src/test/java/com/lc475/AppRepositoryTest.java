package com.lc475;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lc475.model.Employee;
import com.lc475.repository.EmployeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;



@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ShiftmanagerApplication.class)

public class AppRepositoryTest {
   
	@Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees.size(), is(greaterThanOrEqualTo(0)));
    }
   

}


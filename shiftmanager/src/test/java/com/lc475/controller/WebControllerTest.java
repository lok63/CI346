package com.lc475.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lc475.model.Employee;
import com.lc475.repository.EmployeeRepository;

public class WebControllerTest {
	 @InjectMocks
	    private EmployeeController employeeController;

	    @Mock
	    private EmployeeRepository employeeRepository;


	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }


	    @Test
	    public void testEmployeeGetAll() {
	    	Employee returnedEmployee1 = new Employee();
	        returnedEmployee1.setId(1L);
	        Employee returnedEmployee2 = new Employee();
	        returnedEmployee2.setId(2L);
	        List<Employee> employeeList = new ArrayList<Employee>();
	        employeeList.add(returnedEmployee1);
	        employeeList.add(returnedEmployee2);

	        when(employeeRepository.findAll()).thenReturn(employeeList);

	        List<Employee> employees = employeeController.getAll();
	        verify(employeeRepository).findAll();
	        assertThat(employees.size(), is(2));
	        assertThat(employees.get(0).getId(), is(1L));
	        assertThat(employees.get(1).getId(), is(2L));
	    }

	    @Test
	    public void testEmployeeCreate() {
	    	Employee returnedEmployee1 = new Employee();
	        returnedEmployee1.setId(1L);
	        Employee returnedEmployee2 = new Employee();
	        returnedEmployee2.setId(2L);
	        
	        List<Employee> employeeList = new ArrayList<Employee>();
	        employeeList.add(returnedEmployee1);
	        employeeList.add(returnedEmployee2);
	        
	    	Employee neweEployee = new Employee();
	    	neweEployee.setId(3L);


	        when(employeeRepository.findAll()).thenReturn(employeeList);

	        List<Employee> employees = employeeController.create(neweEployee);

	        verify(employeeRepository).findAll();
	        assertThat(employees.size(), is(3));
	        assertThat(employees.get(3).getId(), is(3L));


	    }



	    @Test
	    public void testEmployeeDelete() {
	    	Employee returnedEmployee1 = new Employee();
	        returnedEmployee1.setId(1L);
	        Employee returnedEmployee2 = new Employee();
	        returnedEmployee2.setId(2L);
	        Employee returnedEmployee3 = new Employee();
	        returnedEmployee3.setId(3L);
	        
	        List<Employee> employeeList = new ArrayList<Employee>();
	        employeeList.add(returnedEmployee1);
	        employeeList.add(returnedEmployee2);
	        employeeList.add(returnedEmployee3);

	        when(employeeRepository.findAll()).thenReturn(employeeList);
	        
	        List<Employee> employees = employeeController.delete(2L);


	        verify(employeeRepository).findAll();
	        assertThat(employees.size(), is(2));
	        assertThat(employees.get(0).getId(), is(1L));
	        assertThat(employees.get(1).getId(), is(3L));
	    }


	}

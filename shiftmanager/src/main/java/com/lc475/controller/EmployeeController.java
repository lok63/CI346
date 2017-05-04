package com.lc475.controller;

import com.lc475.model.Employee;
import com.lc475.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    //Dependency injection
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

 
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Employee> create(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Employee> delete (@PathVariable long id){
        employeeRepository.delete(id);
        return employeeRepository.findAll();
    }
    

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable long id, @RequestBody Employee employee){
        Employee existingEmploy = employeeRepository.getOne(id);


        existingEmploy.setDays(employee.getDays());
        existingEmploy.setShiftTime(employee.getShiftTime());
        existingEmploy.setFirstname(employee.getFirstname());
        existingEmploy.setLastname(employee.getLastname());

        BeanUtils.copyProperties(employee,existingEmploy);
        return employeeRepository.saveAndFlush(existingEmploy);
    }
}

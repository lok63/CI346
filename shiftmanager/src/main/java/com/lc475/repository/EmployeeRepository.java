package com.lc475.repository;

import com.lc475.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leo on 02/05/2017.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

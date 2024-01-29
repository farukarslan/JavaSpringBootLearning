package com.omer.cruddemo.dao;

import com.omer.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

                                                    //Entity type, Primary key type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

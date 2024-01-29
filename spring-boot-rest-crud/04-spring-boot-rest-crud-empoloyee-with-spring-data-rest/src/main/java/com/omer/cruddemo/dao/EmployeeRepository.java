package com.omer.cruddemo.dao;

import com.omer.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members") // Instead of exposing '/employees' it will expose '/members' for this given REST repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
                                                        //Entity type, Primary key type
}

package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    Employee addEmployee(String name, double salary);
    ResponseEntity<?> deleteEmployee(Long id);
    Employee updateEmployeeSalary(Long id,String name, double salary);


}

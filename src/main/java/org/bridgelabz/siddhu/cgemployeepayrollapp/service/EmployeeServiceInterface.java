package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    Employee addEmployee(String name, double salary);
    ResponseEntity<?> deleteEmployee(Long id);
    ResponseEntity<?> updateEmployeeSalary(Long id,String name, double salary);


}

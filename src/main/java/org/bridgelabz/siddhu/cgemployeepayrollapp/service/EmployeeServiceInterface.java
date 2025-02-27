package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployee(Long id);
    EmployeeDTO addEmployee(String name, double salary);
    ResponseEntity<?> deleteEmployee(Long id);
    ResponseEntity<?> updateEmployeeSalary(Long id,String name, double salary);


}

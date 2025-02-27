package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.EmployeePayrollData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceInterface {
    List<EmployeePayrollData> getEmployees();
    EmployeePayrollData getEmployee(Long id);
    EmployeePayrollData addEmployee(EmployeeDTO employeeDTO);
    ResponseEntity<?> deleteEmployee(Long id);
    ResponseEntity<?> updateEmployeeSalary(Long id,EmployeeDTO employeeDTO);

    List<EmployeePayrollData> getEmployessByDepartment(String department);
}

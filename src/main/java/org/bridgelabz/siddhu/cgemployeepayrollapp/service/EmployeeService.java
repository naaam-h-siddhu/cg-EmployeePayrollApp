package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(String name, double salary) {
        return  employeeRepository.save(new Employee(name,salary));
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id "+id);
    }

    @Override
    public Employee updateEmployeeSalary(Long id, String name, double salary){
        Employee employee = employeeRepository.findById(id).get();
        if(employeeRepository.existsById(id)){
            employee.setSalary(salary);
            employee.setName(name);
            return employeeRepository.save(employee);
        }
        return null;

    }
}

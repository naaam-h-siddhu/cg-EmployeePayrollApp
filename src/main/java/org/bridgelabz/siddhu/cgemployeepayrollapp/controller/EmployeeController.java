package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController{
    private final List<Employee> employees = new ArrayList<>();

    // get all the employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employees;
    }

    // adding employee to the list
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO.getId(),employeeDTO.getName(),employeeDTO.getSalary());
        employees.add(employee);
        return employee;
    }

    // delete the employee by id
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employees.removeIf(employee -> employee.getId().equals(id));
        return "Successfully deleted the employee";
    }

    // edit employee by id
    @PutMapping("/edit/{id}")
    public Employee editEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        for(Employee emp: employees){
            if(emp.getId().equals(id)){
                emp.setId(employeeDTO.getId());
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                return emp;
            }
        }
        return null;
    }

}

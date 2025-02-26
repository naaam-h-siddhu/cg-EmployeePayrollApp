package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployee(){
        return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee.getName(),employee.getSalary());

    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Employee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee temp = employeeService.updateEmployeeSalary(id,employee.getName(), employee.getSalary());
        if(temp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id " + id);
        }
        return ResponseEntity.ok("Updated Successfully");
    }
}

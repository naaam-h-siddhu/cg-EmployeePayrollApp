package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployee() {
        log.info("Fetching all employees");
        return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("Adding new employee: Name={}, Salary={}", employee.getName(), employee.getSalary());
        return employeeService.addEmployee(employee.getName(), employee.getSalary());
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID={}", id);
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Employee(@PathVariable Long id) {
        log.info("Deleting employee with ID={}", id);
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        log.info("Updating employee with ID={}, New Name={}, New Salary={}", id, employee.getName(), employee.getSalary());
        Employee temp = employeeService.updateEmployeeSalary(id, employee.getName(), employee.getSalary());
        if (temp == null) {
            log.warn("Employee with ID={} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id " + id);
        }
        log.info("Employee with ID={} updated successfully", id);
        return ResponseEntity.ok("Updated Successfully");
    }
}

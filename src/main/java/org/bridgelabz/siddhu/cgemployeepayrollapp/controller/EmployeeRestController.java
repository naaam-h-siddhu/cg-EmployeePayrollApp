package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<EmployeeDTO> getEmployee() {
        log.info("Fetching all employees");
        return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Adding new employee: Name={}, Salary={}", employeeDTO.getName(), employeeDTO.getSalary());
        return employeeService.addEmployee(employeeDTO.getName(), employeeDTO.getSalary());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@Valid @PathVariable Long id) {
        log.info("Fetching employee with ID={}", id);
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Employee(@PathVariable Long id) {
        log.info("Deleting employee with ID={}", id);
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID={}, New Name={}, New Salary={}", id, employeeDTO.getName(), employeeDTO.getSalary());
        return employeeService.updateEmployeeSalary(id, employeeDTO.getName(), employeeDTO.getSalary());
    }
}

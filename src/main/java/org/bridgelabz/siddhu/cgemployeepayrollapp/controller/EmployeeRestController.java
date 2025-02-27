package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.EmployeePayrollData;
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


    @PostMapping("/add")
    public EmployeePayrollData addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        log.info("Adding Employee");
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping()
    public List<EmployeePayrollData> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeePayrollData getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployeeSalary(id,employeeDTO);
    }

    @GetMapping("/dept/{departments}")
    public List<EmployeePayrollData> getEmployeeByDepartments(@PathVariable("departments") String departments) {
        return employeeService.getEmployessByDepartment(departments);
    }

}

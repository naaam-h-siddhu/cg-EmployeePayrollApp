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
    public EmployeePayrollData addEmployee(@RequestBody EmployeeDTO employeeDTO){
        log.info("Adding Employee");
        return employeeService.addEmployee(employeeDTO);
    }

}

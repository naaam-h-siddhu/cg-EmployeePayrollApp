package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class RestEmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeRepository.save(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
         employeeRepository.deleteById(id);
    }
}

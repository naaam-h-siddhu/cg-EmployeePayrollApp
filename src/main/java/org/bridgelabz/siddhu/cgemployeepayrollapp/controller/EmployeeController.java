package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // Show Employee Page
    @GetMapping
    public String showEmployees(Model model) {
        model.addAttribute("employees", repository.findAll());
        return "employee";
    }

    // Add Employee
    @PostMapping("/add")
    public String addEmployee(@RequestParam String name, @RequestParam String salary) {
        Employee employee = new Employee(name, salary);
        repository.save(employee);
        return "redirect:/employee";
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/employee";
    }
}

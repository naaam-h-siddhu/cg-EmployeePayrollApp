package org.bridgelabz.siddhu.cgemployeepayrollapp.controller;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.Employee;
import org.bridgelabz.siddhu.cgemployeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public String getEmployees(Model model){

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees",employeeList);
        return "employee-list";

    }
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form"; // This should map to "employee-form.html"
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee.getName(),employee.getSalary());
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}

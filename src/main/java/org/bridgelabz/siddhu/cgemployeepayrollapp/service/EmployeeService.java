package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public EmployeeDTO addEmployee(String name, double salary) {
        return  employeeRepository.save(new EmployeeDTO(name,salary));
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
    public ResponseEntity<?> updateEmployeeSalary(Long id, String name, double salary){
        EmployeeDTO employeeDTO = employeeRepository.findById(id).get();
        if(employeeRepository.existsById(id)){
            employeeDTO.setSalary(salary);
            employeeDTO.setName(name);
            employeeRepository.save(employeeDTO);
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id "+id);

    }
}

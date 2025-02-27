package org.bridgelabz.siddhu.cgemployeepayrollapp.service;

import lombok.extern.slf4j.Slf4j;
import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;
import org.bridgelabz.siddhu.cgemployeepayrollapp.entity.EmployeePayrollData;
import org.bridgelabz.siddhu.cgemployeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeePayrollData> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public EmployeePayrollData addEmployee(EmployeeDTO employeeDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeeDTO);
        log.debug("Employee data: "+employeePayrollData.toString());

        return  employeeRepository.save(employeePayrollData);
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
    public ResponseEntity<?> updateEmployeeSalary(Long id,EmployeeDTO employeeDTO){
        EmployeePayrollData empData = employeeRepository.findById(id).get();
        if(employeeRepository.existsById(id)){
            empData.setSalary(employeeDTO.getSalary());
            empData.setName(employeeDTO.getName());
            empData.setDepartments(employeeDTO.getDepartments());
            empData.setGender(employeeDTO.getGender());
            empData.setProfilePic(employeeDTO.getProfilePic());
            empData.setStartDate(employeeDTO.getStartDate());
            employeeRepository.save(empData);
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found with id "+id);

    }
    @Override
    public List<EmployeePayrollData> getEmployessByDepartment(String department) {
        return employeeRepository.findEmployeePayrollDataByDepartments(department);
    }
}

package org.bridgelabz.siddhu.cgemployeepayrollapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.bridgelabz.siddhu.cgemployeepayrollapp.dto.EmployeeDTO;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "Employee_Payroll")
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long id;

    @Column(name = "EmployeeName")
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;


    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "EmployeeId"))
    @Column(name = "department")
    private List<String> departments;


    public EmployeePayrollData() {
    }
    public EmployeePayrollData(EmployeeDTO employeeDTO){

        this.name = employeeDTO.getName();
        this.salary= employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.note = employeeDTO.getNote();
        this.startDate = employeeDTO.getStartDate();
        this.profilePic = employeeDTO.getProfilePic();
        this.departments= employeeDTO.getDepartments();

    }
}

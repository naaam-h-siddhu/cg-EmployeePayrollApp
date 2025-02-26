package org.bridgelabz.siddhu.cgemployeepayrollapp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Only alphabets and space allowed")
    private String name;


    private double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

package org.bridgelabz.siddhu.cgemployeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Za-z ]+$",message = "Only alphabets and space allowed")
    @NotEmpty
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;


}

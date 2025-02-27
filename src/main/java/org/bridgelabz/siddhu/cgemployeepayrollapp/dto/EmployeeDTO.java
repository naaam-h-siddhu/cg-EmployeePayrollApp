package org.bridgelabz.siddhu.cgemployeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Za-z ]+$",message = "Only alphabets and space allowed")
    @NotEmpty
    private String name;

    @Min(value = 10000, message = "minimum wage should be 10000")
    private double salary;

    @Pattern(regexp = "male|female",message = "Gender should be male or female")
    private String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "start date should not be empty")
    @PastOrPresent(message = "start date should be past or today!! Enter the date")
    private LocalDate startDate;

    @NotBlank(message = "note cannot be empty")
    private String note;
    @NotBlank(message = "profile pic should be there")
    private String profilePic;

    private List<String> departments;

}

package com.example.assignment11.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeModel {
    
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2)
    private String ID;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2)
    private String name;


    @NotEmpty(message = "Age shouldn't be empty")
    @Pattern(regexp="\\d+", message="Age should be Integer")
    @Min(25)
    private String age;

    @NotEmpty(message = "Position shouldn't be empty")
    @Pattern(regexp = "supervisor|coordinator", message = "Position should be supervisor or coordinator  ")
    private String position;

    @AssertFalse(message = "On Leave shouldn't be true ")
    private Boolean onLeave;

    @NotEmpty(message = "Employment Year shouldn't be empty")
    @Pattern(regexp="\\d{4}", message="Employment Year should be a valid format")
    //@Max(LocalDate.now().getYear())
    private String employmentYear;

    @NotEmpty(message = "Annual Leave shouldn't be empty")
    @Pattern(regexp="\\d+", message="Annual Leave should be Integer")
    private String annualLeave;
}

package com.example.assignment11.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeModel {

    @NotEmpty(message = "It shouldn't be empty")
    @Min(2)
    private String ID;

    @NotEmpty(message = "It shouldn't be empty")
    @Min(4)
    private String name;

    @NotNull(message = "It shouldn't be empty")
    //@Pattern(regexp = "[0-9]+")
    //@Digits(integer = 2,fraction = 0)
    @Min(25)
    private int age;

    @NotEmpty(message = "It shouldn't be empty")
    //@Pattern(regexp = "supervisor|coordinator")
    private String position;

    @AssertFalse(message = "It shouldn't be true ")
    private boolean onLeave;

    @NotNull(message = "It shouldn't be empty")
    //@Pattern(regexp = "[0-9]+")
    //@PastOrPresent
    private int employmentYear;

    @NotNull(message = "It shouldn't be empty")
    //@Pattern(regexp = "[0-9]+")
    private int annualLeave;
}

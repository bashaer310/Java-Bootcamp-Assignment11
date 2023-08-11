package com.example.assignment11.Controller;


import com.example.assignment11.ApiResponse.ApiResponse;
import com.example.assignment11.Model.EmployeeModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    ArrayList<EmployeeModel> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<EmployeeModel> getEmployees(){
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid EmployeeModel employee, Errors error){

        if (error.hasErrors())
        {
            String m=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        if (Integer.valueOf(employee.getEmploymentYear())>LocalDate.now().getYear())
        {
            return ResponseEntity.status(400).body("Employment Year should be in past or in present ");
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee added"));
    }

    @PutMapping ("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index,@RequestBody @Valid EmployeeModel employee, Errors errors){

        if(errors.hasErrors()){
            String m=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        if (Integer.valueOf(employee.getEmploymentYear())>LocalDate.now().getYear())
        {
            return ResponseEntity.status(400).body("Employment Year should be in past or in present ");
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee updated"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee deleted"));
    }

    @PutMapping("applyannualleave/{index}")
    public ResponseEntity applyAnnualLeave(@PathVariable int index){

        if(employees.get(index).getOnLeave() == true || Integer.valueOf(employees.get(index).getAnnualLeave()) ==0 ){
            return ResponseEntity.status(400).body(new ApiResponse("Can't apply an annual leave for this employee"));
        }
        employees.get(index).setAnnualLeave(String.valueOf(Integer.valueOf(employees.get(index).getAnnualLeave()) - 1));
        employees.get(index).setOnLeave(true);
        return ResponseEntity.status(200).body(new ApiResponse("Employee applied an annual leave"));
    }

}

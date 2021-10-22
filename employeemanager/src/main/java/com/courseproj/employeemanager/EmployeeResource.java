package com.courseproj.employeemanager;

import com.courseproj.employeemanager.exception.EmployeeException;
import com.courseproj.employeemanager.model.Employee;
import com.courseproj.employeemanager.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
//@CrossOrigin(origins = "http://localhost:4200/admin")
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(boolean exception)
                    throws EmployeeException{
        if (exception) {
            throw new EmployeeException("EmployeeException in getAllEmployees Controller");
        }
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Get an employee by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employee",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id, boolean exception)
                    throws EmployeeException {
            if (exception) {
                throw new EmployeeException("EmployeeException in getEmployeeById Controller");
            }
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")                                                                       // BindingResult bindingResult
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee, boolean exception)
                    throws EmployeeException{
        if (exception) {
            throw new EmployeeException("EmployeeException in addEmployee Controller");
        }
//        if(bindingResult.hasErrors())
//        {
//
//        }
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, boolean exception)
                    throws EmployeeException{
        if (exception) {
            throw new EmployeeException("EmployeeException in updateEmployee Controller");
        }
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id, boolean exception)
                    throws EmployeeException{
        if (exception) {
            throw new EmployeeException("EmployeeException in deleteEmployee Controller");
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}




package com.courseproj.employeemanager;

import com.courseproj.employeemanager.exception.EmployeeException;
import com.courseproj.employeemanager.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Response> handleException(EmployeeException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
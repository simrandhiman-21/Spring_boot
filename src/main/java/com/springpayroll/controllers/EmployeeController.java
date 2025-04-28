package com.springpayroll.controllers;


import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String employee() {
        return "Hello World from Employee Controller";
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> employeeAll() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> employeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable Integer id,@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<Object> employeeQuery(@RequestParam("departmentName") String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(employeeService.getEmployeeByDepartmentName(departmentName));
    }
}

package com.springpayroll.controllers;

import com.springpayroll.dtos.DepartmentDTO;
import com.springpayroll.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String department() {
        return "Hello World From Department Controller";
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer id) {
        return new ResponseEntity<>(departmentService.getDeptById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.createDept(departmentDTO);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDept(id, departmentDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDept(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}

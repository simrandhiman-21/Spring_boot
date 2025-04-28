package com.springpayroll.controllers;


import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.services.PayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping()
    public String payroll() {
        return "Hello from PayrollController";
    }

    @GetMapping("/all")
    public ResponseEntity<List<PayrollDTO>> payrollAll() {
        return new ResponseEntity<>(payrollService.getAllPayrolls(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> payrollById(@PathVariable Integer id) {
        return new ResponseEntity<>(payrollService.getPayrollById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createPayroll(@RequestBody PayrollDTO payrollDTO) {
        payrollService.createPayroll(payrollDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updatePayroll(@PathVariable Integer id, @RequestBody PayrollDTO payrollDTO) {
        payrollService.updatePayroll(id, payrollDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePayroll(@PathVariable Integer id) {
        payrollService.deletePayroll(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}

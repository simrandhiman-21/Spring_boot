package com.springpayroll.services;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Employee;
import com.springpayroll.mappings.PayrollMapper;
import com.springpayroll.entities.Payroll;
import com.springpayroll.exceptions.PayrollException;
import com.springpayroll.repositories.IEmployeeRepository;
import com.springpayroll.repositories.IPayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayrollService {
    private final IPayrollRepository payrollRepository;
    private final PayrollMapper payrollMapper;

    public PayrollService(IPayrollRepository payrollRepository, PayrollMapper payrollMapper) {        this.payrollRepository = payrollRepository;
        this.payrollMapper = payrollMapper;

    }

    public PayrollDTO getPayrollById(int id) {
        Optional<Payroll> payrollOpt = payrollRepository.findById(id);
        if (payrollOpt.isPresent()) {
            return payrollMapper.toPayrollDTO(payrollOpt.get());
        } else {
            throw new PayrollException("Payroll not found");
        }
    }

    public List<PayrollDTO> getAllPayrolls() {
        List<Payroll> payrolls = payrollRepository.findAll();
        return payrolls.stream().map(payrollMapper::toPayrollDTO).collect(Collectors.toList());
    }

    public void createPayroll(PayrollDTO payrollDTO) {
        if (payrollDTO.getId() != null && payrollRepository.existsById(payrollDTO.getId())) {
            throw new PayrollException("Payroll with ID " + payrollDTO.getId() + " already exists");
        }
        payrollRepository.save(payrollMapper.toPayrollEntity(payrollDTO));
    }

    public void updatePayroll(Integer id, PayrollDTO payrollDTO) {
        if (!payrollRepository.existsById(id)) {
            throw new PayrollException("Cannot update. Payroll with ID " + id + " does not exist");
        }
        Payroll payroll = payrollMapper.toPayrollEntity(payrollDTO);
        payroll.setId(id);
        payrollRepository.save(payroll);
    }

    public void deletePayroll(Integer id) {
        if (!payrollRepository.existsById(id)) {
            throw new PayrollException("Payroll with ID " + id + " does not exist");
        }
        payrollRepository.deleteById(id);
    }
}

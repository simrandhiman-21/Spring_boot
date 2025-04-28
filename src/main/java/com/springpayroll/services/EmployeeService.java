package com.springpayroll.services;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Department;
import com.springpayroll.entities.Payroll;
import com.springpayroll.exceptions.EmployeeException;
import com.springpayroll.exceptions.PayrollException;
import com.springpayroll.mappings.EmployeeMapper;
import com.springpayroll.entities.Employee;
import com.springpayroll.repositories.IDepartmentRepository;
import com.springpayroll.repositories.IEmployeeRepository;
import com.springpayroll.repositories.IPayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final IPayrollRepository payrollRepository;
    private final IDepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(IEmployeeRepository employeeRepository, EmployeeMapper employeeMapper, IPayrollRepository payrollRepository, IDepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.payrollRepository = payrollRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            return employeeMapper.toEmployeeDTO(employeeOpt.get());
        } else {
            throw new EmployeeException("Employee not found");
        }
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toEmployeeDTO).collect(Collectors.toList());
    }

    public void createEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getId() != null && employeeRepository.existsById(employeeDTO.getId())) {
            throw new EmployeeException("Employee with ID " + employeeDTO.getId() + " already exists");
        }
        Employee employee = employeeMapper.toEmployeeEntity(employeeDTO);

        if (employeeDTO.getPayrollId() != null) {
            Payroll payroll = payrollRepository.findById(employeeDTO.getPayrollId())
                    .orElseThrow(() -> new PayrollException("Payroll not found"));
            employee.setPayroll(payroll);
        }
        if (employeeDTO.getDeptIds() != null && !employeeDTO.getDeptIds().isEmpty()) {
            List<Department> departments = departmentRepository.findAllById(employeeDTO.getDeptIds());
            employee.setDepartments(departments);
        }


        log.info("Creating employee {}", employee);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeException("Cannot update. Employee with ID " + id + " does not exist");
        }
        Employee employee = employeeMapper.toEmployeeEntity(employeeDTO);

        if (employeeDTO.getPayrollId() != null) {
            Payroll payroll = payrollRepository.findById(employeeDTO.getPayrollId())
                    .orElseThrow(() -> new PayrollException("Payroll not found"));
            employee.setPayroll(payroll);
        }

        if (employeeDTO.getDeptIds() != null && !employeeDTO.getDeptIds().isEmpty()) {
            List<Department> departments = departmentRepository.findAllById(employeeDTO.getDeptIds());
            employee.setDepartments(departments);
        }
        employee.setId(id);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeException("Cannot delete. Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getEmployeeByDepartmentName(String departmentName) {
        return employeeRepository.findEmployeeByDepartment(departmentName).stream()
                .map(employeeMapper::toEmployeeDTO).collect(Collectors.toList());
    }
}

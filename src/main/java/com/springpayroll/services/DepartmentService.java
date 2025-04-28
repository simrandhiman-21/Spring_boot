package com.springpayroll.services;

import com.springpayroll.dtos.DepartmentDTO;
import com.springpayroll.entities.Department;
import com.springpayroll.exceptions.DepartmentException;
import com.springpayroll.mappings.DepartmentMapper;
import com.springpayroll.repositories.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final IDepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(IDepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentDTO getDeptById(int id) {
        Optional<Department> deptOpt = departmentRepository.findById(id);
        if (deptOpt.isPresent()) {
            return departmentMapper.toDepartmentDTO(deptOpt.get());
        } else {
            throw new DepartmentException("Department not found");
        }
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentMapper::toDepartmentDTO)
                .collect(Collectors.toList());
    }

    public void createDept(DepartmentDTO departmentDTO) {
        if (departmentDTO.getId() != null && departmentRepository.existsById(departmentDTO.getId())) {
            throw new DepartmentException("Department with ID " + departmentDTO.getId() + " already exists");
        }

        departmentRepository.save(departmentMapper.toDepartmentEntity(departmentDTO));
    }

    public void updateDept(Integer id, DepartmentDTO departmentDTO) {
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentException("Department with ID " + id + " does not exist");
        }

        Department department = departmentMapper.toDepartmentEntity(departmentDTO);
        department.setId(id);

        departmentRepository.save(department);
    }

    public void deleteDept(Integer id) {
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentException("Department with ID " + id + " does not exist");
        }
        departmentRepository.deleteById(id);
    }
}

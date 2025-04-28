package com.springpayroll.mappings;

import com.springpayroll.dtos.EmployeeDTO;
import com.springpayroll.entities.Department;
import com.springpayroll.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "payroll.id", target = "payrollId")
    @Mapping(source = "departments", target = "deptIds", qualifiedByName = "mapDepartmentsToIds")
    EmployeeDTO toEmployeeDTO(Employee employee);

    @Mapping(source = "payrollId", target = "payroll.id")
    @Mapping(source = "deptIds", target = "departments", qualifiedByName = "mapIdsToDepartments")
    Employee toEmployeeEntity(EmployeeDTO employeeDTO);

    @Named("mapDepartmentsToIds")
    default List<Integer> mapDepartmentsToIds(List<Department> departments) {
        if (departments == null) {
            return null;
        }
        return departments.stream()
                .map(Department::getId)
                .collect(Collectors.toList());
    }

    @Named("mapIdsToDepartments")
    default List<Department> mapIdsToDepartments(List<Integer> ids) {
        return ids == null ? null : ids.stream()
                .map(id -> {
                    Department dept = new Department();
                    dept.setId(id);
                    return dept;
                })
                .collect(Collectors.toList());
    }
}

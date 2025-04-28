package com.springpayroll.mappings;

import com.springpayroll.dtos.DepartmentDTO;
import com.springpayroll.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(source = "name", target = "name")
    DepartmentDTO toDepartmentDTO(Department department);

    @Mapping(source = "name", target = "name")
    Department toDepartmentEntity(DepartmentDTO departmentDTO);
}

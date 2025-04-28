package com.springpayroll.mappings;

import com.springpayroll.dtos.PayrollDTO;
import com.springpayroll.entities.Payroll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface PayrollMapper {
    PayrollMapper INSTANCE = Mappers.getMapper(PayrollMapper.class);

    @Mapping(source = "salary", target = "salary")
    PayrollDTO toPayrollDTO(Payroll payroll);

    @Mapping(source = "salary", target = "salary")
    Payroll toPayrollEntity(PayrollDTO payrollDTO);
}

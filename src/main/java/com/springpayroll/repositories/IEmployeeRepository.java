package com.springpayroll.repositories;


import com.springpayroll.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e JOIN e.departments d WHERE d.name = :departmentName")
    List<Employee> findEmployeeByDepartment(@Param("departmentName") String departmentName);
}

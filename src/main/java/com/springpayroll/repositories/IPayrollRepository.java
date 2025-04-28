package com.springpayroll.repositories;


import com.springpayroll.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayrollRepository extends JpaRepository<Payroll, Integer> {
}

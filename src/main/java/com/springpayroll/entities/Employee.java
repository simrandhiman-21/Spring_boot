package com.springpayroll.entities;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "payroll_id")

    private Payroll payroll;

    @ManyToMany
    @JoinTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;
}

package com.SpringIntro.Springintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {

    @Autowired
    DepartmentBean dept;

    public void display(){
        System.out.println("Employee Works in "+dept.getDeptName());
    }


}

package com.springpayroll.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class PayrollDTO implements Serializable {
    private Integer id;
    @NotNull
    private double salary;

}

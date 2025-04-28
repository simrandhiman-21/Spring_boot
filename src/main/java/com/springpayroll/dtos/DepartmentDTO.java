package com.springpayroll.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
public class DepartmentDTO implements Serializable {
    private Integer id;

    @NotEmpty
    private String name;
}

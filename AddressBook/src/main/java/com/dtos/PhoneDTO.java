package com.addressbook.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {
    private Integer id;
    private String number;
    private Integer contactId;
}

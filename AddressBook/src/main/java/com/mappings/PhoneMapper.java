package com.addressbook.mappings;

import com.addressbook.dtos.PhoneDTO;
import com.addressbook.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ContactMapper.class})
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(source = "contact.id", target = "contactId")
    PhoneDTO toPhoneDTO(Phone phone);

    @Mapping(source = "contactId", target = "contact.id")
    Phone toPhone(PhoneDTO phoneDTO);
}

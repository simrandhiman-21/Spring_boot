package com.addressbook.mappings;

import com.addressbook.dtos.ContactDTO;
import com.addressbook.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDTO toContactDTO(Contact contact);

    Contact toContact(ContactDTO contactDTO);
}

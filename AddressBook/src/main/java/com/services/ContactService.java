package com.addressbook.services;

import com.addressbook.dtos.ContactDTO;
import com.addressbook.entities.Contact;
import com.addressbook.mappings.ContactMapper;
import com.addressbook.repositories.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public List<ContactDTO> getAllContacts() {
        log.info("Getting all contacts");
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(contactMapper::toContactDTO).collect(Collectors.toList());
    }

    public ContactDTO getContactById(int id) {
        log.info("Getting contact with id {}", id);
        Contact contact = contactRepository.findById(id).orElse(null);
        return contactMapper.toContactDTO(contact);
    }

    public ContactDTO addContact(ContactDTO contactDTO) {
        log.info("Adding contact {}", contactDTO);
        Contact contact = contactMapper.toContact(contactDTO);
        contact = contactRepository.save(contact);
        return contactMapper.toContactDTO(contact);
    }

    public ContactDTO updateContact(Integer id, ContactDTO contactDTO) {
        log.info("Updating contact with id {}", id);
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contact = contactMapper.toContact(contactDTO);
            contact.setId(id);
            contactRepository.save(contact);
            return contactMapper.toContactDTO(contact);
        }
        return null;
    }

    public boolean deleteContact(Integer id) {
        log.info("Deleting contact with id {}", id);
        if (contactRepository.findById(id).isPresent()) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

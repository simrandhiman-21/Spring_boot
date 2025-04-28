package com.addressbook.controllers;

import com.addressbook.dtos.ContactDTO;
import com.addressbook.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(final ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable final int id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @PostMapping()
    public ResponseEntity<ContactDTO> createContact(@RequestBody final ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.addContact(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable final int id, @RequestBody final ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.updateContact(id, contactDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable final int id) {
        return ResponseEntity.ok(contactService.deleteContact(id));
    }
}

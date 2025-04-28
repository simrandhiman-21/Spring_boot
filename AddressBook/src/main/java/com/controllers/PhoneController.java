package com.addressbook.controllers;

import com.addressbook.dtos.PhoneDTO;
import com.addressbook.services.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(final PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PhoneDTO>> getAllPhones() {
        return ResponseEntity.ok(phoneService.getAllPhones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDTO> getPhoneById(@PathVariable final int id) {
        return ResponseEntity.ok(phoneService.getPhoneById(id));
    }

    @PostMapping()
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody final PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.createPhone(phoneDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneDTO> updatePhone(@PathVariable final int id, @RequestBody final PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.updatePhone(id, phoneDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePhone(@PathVariable final int id) {
        return ResponseEntity.ok(phoneService.deletePhone(id));
    }
}

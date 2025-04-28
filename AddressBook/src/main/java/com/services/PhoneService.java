package com.addressbook.services;

import com.addressbook.dtos.PhoneDTO;
import com.addressbook.entities.Phone;
import com.addressbook.mappings.PhoneMapper;
import com.addressbook.repositories.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneService(final PhoneRepository phoneRepository, final PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    public List<PhoneDTO> getAllPhones() {
        log.info("Getting all phones");
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream().map(phoneMapper::toPhoneDTO).collect(Collectors.toList());
    }

    public PhoneDTO getPhoneById(int id) {
        log.info("Getting phone by id: {}", id);
        Phone phone = phoneRepository.findById(id).orElse(null);
        return phoneMapper.toPhoneDTO(phone);
    }

    public PhoneDTO createPhone(PhoneDTO phoneDTO) {
        log.info("Creating phone: {}", phoneDTO);
        Phone phone = phoneMapper.toPhone(phoneDTO);
        phone = phoneRepository.save(phone);
        return phoneMapper.toPhoneDTO(phone);
    }

    public PhoneDTO updatePhone(Integer id, PhoneDTO phoneDTO) {
            log.info("Updating phone: {}", phoneDTO);
        Phone phone = phoneRepository.findById(id).orElse(null);
        if (phone != null) {
            phone = phoneMapper.toPhone(phoneDTO);
            phone.setId(id);
            phoneRepository.save(phone);
            return phoneMapper.toPhoneDTO(phone);
        }
        return null;
    }

    public boolean deletePhone(int id) {
        log.info("Deleting phone: {}", id);
        if (phoneRepository.findById(id).isPresent()) {
            phoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

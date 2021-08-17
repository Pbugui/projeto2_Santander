package com.one.digitalinnovation.personapi.service;

import com.one.digitalinnovation.personapi.dto.request.PersonDTO;
import com.one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.mapper.PersonMapper;
import com.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private  final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .messsge("Created peson with ID " + savedPerson.getId())
                .build();
    }
}

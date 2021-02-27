package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.person.dto.request.PersonRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import com.gabriellopesjds.moneyapi.person.persistence.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegisterPersonService {

    private final PersonRepository personRepository;
    private final PersonFactory personFactory;

    @Transactional
    public PersonResponseDTO savePerson(PersonRequestDTO requestDTO) {
        Person person = personFactory.fromValue(requestDTO);
        Person personSaved = personRepository.saveAndFlush(person);
        return personFactory.buildResponse(personSaved);
    }

}

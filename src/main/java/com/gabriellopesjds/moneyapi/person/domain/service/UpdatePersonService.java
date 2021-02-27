package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.person.dto.request.PersonRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import com.gabriellopesjds.moneyapi.person.persistence.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UpdatePersonService {

    private final PersonRepository personRepository;
    private final GetterPersonService getterPersonService;
    private final PersonFactory personFactory;

    @Transactional
    public PersonResponseDTO updatePerson(UUID id, PersonRequestDTO personRequestDTO) {
        Person person = getterPersonService.findByIdAndStatusActive(id);
        Person personUpdate = personFactory.fromValue(personRequestDTO);
        personUpdate.setId(person.getId());
        return personFactory.buildResponse(personRepository.saveAndFlush(personUpdate));
    }

}

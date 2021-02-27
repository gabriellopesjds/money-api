package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import com.gabriellopesjds.moneyapi.person.persistence.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum.EXCLUDED;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeletePersonService {

    private final PersonRepository personRepository;
    private final GetterPersonService getterPersonService;

    @Transactional
    public void deleteById(UUID id) {
        Person person = getterPersonService.findByIdAndStatusActive(id);
        person.setStatus(EXCLUDED);
        personRepository.save(person);
    }

}

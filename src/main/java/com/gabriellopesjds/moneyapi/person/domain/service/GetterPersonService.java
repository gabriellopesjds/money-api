package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.exception.BusinessException;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import com.gabriellopesjds.moneyapi.person.persistence.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum.ACTIVE;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetterPersonService {

    private final PersonRepository personRepository;
    private final PersonFactory personFactory;

    public List<PersonResponseDTO> listPerson() {
        return personRepository.findAllByStatus(ACTIVE)
            .stream()
            .map(personFactory::buildResponse)
            .collect(Collectors.toList());
    }

    public Person findByIdAndStatusActive(UUID id) {
        return personRepository.findByIdAndStatus(id, ACTIVE).orElseThrow(() -> new BusinessException("MONEY-001"));
    }

    public PersonResponseDTO findResponseByIdAndStatusActive(UUID id) {
        return personFactory.buildResponse(findByIdAndStatusActive(id));
    }

}

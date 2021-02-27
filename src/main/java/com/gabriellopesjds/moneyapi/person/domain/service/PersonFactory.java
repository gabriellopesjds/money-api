package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.person.dto.request.PersonRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum.ACTIVE;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonFactory {

    private final AddressFactory addressFactory;

    public Person fromValue(PersonRequestDTO requestDTO) {
        Person person = new Person();
        person.setName(requestDTO.getName());
        person.setStatus(ACTIVE);
        person.setAddressList(addressFactory.fromValue(requestDTO.getAddressList(), person));
        return person;
    }

    public PersonResponseDTO buildResponse(Person personSaved) {
        return PersonResponseDTO.builder()
            .id(personSaved.getId())
            .name(personSaved.getName())
            .status(personSaved.getStatus())
            .addressList(addressFactory.buildResponseList(personSaved))
            .build();
    }

}

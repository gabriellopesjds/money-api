package com.gabriellopesjds.moneyapi.person.application.service;

import com.gabriellopesjds.moneyapi.person.dto.request.PersonRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.service.DeletePersonService;
import com.gabriellopesjds.moneyapi.person.domain.service.GetterPersonService;
import com.gabriellopesjds.moneyapi.person.domain.service.RegisterPersonService;
import com.gabriellopesjds.moneyapi.person.domain.service.UpdatePersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonApplicationService {

    private final RegisterPersonService registerPersonService;
    private final GetterPersonService getterPersonService;
    private final DeletePersonService deletePersonService;
    private final UpdatePersonService updatePersonService;

    public PersonResponseDTO savePerson(PersonRequestDTO requestDTO) {
        return registerPersonService.savePerson(requestDTO);
    }

    public List<PersonResponseDTO> listPerson() {
        return getterPersonService.listPerson();
    }

    public void deletePerson(UUID id) {
        deletePersonService.deleteById(id);
    }

    public PersonResponseDTO getPerson(UUID id) {
        return getterPersonService.findResponseByIdAndStatusActive(id);
    }

    public PersonResponseDTO updatePerson(UUID id, PersonRequestDTO personRequestDTO) {
        return updatePersonService.updatePerson(id, personRequestDTO);
    }

}

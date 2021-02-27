package com.gabriellopesjds.moneyapi.rest.api;

import com.gabriellopesjds.moneyapi.person.application.service.PersonApplicationService;
import com.gabriellopesjds.moneyapi.person.dto.request.PersonRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.PersonResponseDTO;
import com.gabriellopesjds.moneyapi.rest.dto.BaseResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping("persons")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonApplicationService personApplicationService;

    @PostMapping
    public ResponseEntity<PersonResponseDTO> savePerson(@RequestBody PersonRequestDTO requestDTO){
        PersonResponseDTO responseDTO = personApplicationService.savePerson(requestDTO);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDTO.getId())
            .toUri();

        return ResponseEntity.created(uri)
            .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<PersonResponseDTO>>> listPerson(){
        List<PersonResponseDTO> responseDTOList = personApplicationService.listPerson();
        return responseDTOList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(BaseResponse.withData(responseDTOList));
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonResponseDTO> getPerson(@PathVariable UUID id){
        return ResponseEntity.ok(personApplicationService.getPerson(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePerson(@PathVariable UUID id){
        personApplicationService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable UUID id, @Valid @RequestBody PersonRequestDTO personRequestDTO){
        PersonResponseDTO responseDTO = personApplicationService.updatePerson(id, personRequestDTO);

        return ResponseEntity.accepted()
            .body(responseDTO);
    }

}

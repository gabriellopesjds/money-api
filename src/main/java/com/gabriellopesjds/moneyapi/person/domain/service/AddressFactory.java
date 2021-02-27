package com.gabriellopesjds.moneyapi.person.domain.service;

import com.gabriellopesjds.moneyapi.person.dto.request.AddressRequestDTO;
import com.gabriellopesjds.moneyapi.person.dto.response.AddressResponseDTO;
import com.gabriellopesjds.moneyapi.person.domain.model.Address;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressFactory {

    public List<Address> fromValue(List<AddressRequestDTO> addressList, Person person) {
        return addressList.stream()
            .map(address -> fromValue(address, person))
            .collect(Collectors.toList());
    }

    private Address fromValue(AddressRequestDTO addressRequestDTO, Person person){
        Address address = new Address();
        address.setPublicPlace(addressRequestDTO.getPublicPlace());
        address.setNumber(addressRequestDTO.getNumber());
        address.setComplement(addressRequestDTO.getComplement());
        address.setDistrict(addressRequestDTO.getDistrict());
        address.setCep(addressRequestDTO.getCep());
        address.setCity(addressRequestDTO.getCity());
        address.setState(addressRequestDTO.getState());
        address.setPerson(person);
        return address;
    }

    public List<AddressResponseDTO> buildResponseList(Person personSaved) {
        return personSaved.getAddressList().stream()
            .map(this::buildResponse)
            .collect(Collectors.toList());
    }

    private AddressResponseDTO buildResponse(Address address) {
        return AddressResponseDTO.builder()
            .publicPlace(address.getPublicPlace())
            .number(address.getNumber())
            .city(address.getCity())
            .build();
    }

}

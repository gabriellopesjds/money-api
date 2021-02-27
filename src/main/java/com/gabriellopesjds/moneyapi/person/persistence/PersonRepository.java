package com.gabriellopesjds.moneyapi.person.persistence;

import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    List<Person> findAllByStatus(StatusEnum statusEnum);
    Optional<Person> findByIdAndStatus(UUID id, StatusEnum statusEnum);

}

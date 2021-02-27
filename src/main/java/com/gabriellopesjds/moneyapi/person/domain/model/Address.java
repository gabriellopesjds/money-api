package com.gabriellopesjds.moneyapi.person.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Getter
@Setter
@GenericGenerator(name = "UUID_generator", strategy = "uuid2")
public class Address {

    @Id
    @GeneratedValue(generator = "UUID_generator")
    private UUID id;

    @Column(name = "public_place")
    private String publicPlace;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "district")
    private String district;

    @Column(name = "cep")
    private String cep;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "person_id", columnDefinition = "BINARY(16)")
    private Person person;
}

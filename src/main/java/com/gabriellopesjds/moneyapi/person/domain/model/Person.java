package com.gabriellopesjds.moneyapi.person.domain.model;

import com.gabriellopesjds.moneyapi.person.domain.model.enumereted.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Getter
@Setter
@GenericGenerator(name = "UUID_generator", strategy = "uuid2")
public class Person {

    @Id
    @GeneratedValue(generator = "UUID_generator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "person")
    private List<Address> addressList = new ArrayList<>();
}

package com.gabriellopesjds.moneyapi.category.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Getter
@Setter
@GenericGenerator(name = "UUID_generator", strategy = "uuid2")
public class Category {

    @Id
    @GeneratedValue(generator = "UUID_generator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
}

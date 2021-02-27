package com.gabriellopesjds.moneyapi.launch.domain.model;

import com.gabriellopesjds.moneyapi.category.domain.model.Category;
import com.gabriellopesjds.moneyapi.launch.domain.model.enumerated.LaunchTypeEnum;
import com.gabriellopesjds.moneyapi.person.domain.model.Person;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "launch")
@Getter
@Setter
@GenericGenerator(name = "UUID_generator", strategy = "uuid2")
public class Launch {

    @Id
    @GeneratedValue(generator = "UUID_generator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "observation")
    private String observation;

    @Enumerated(EnumType.STRING)
    @Column (name = "type")
    private LaunchTypeEnum typeEnum;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}

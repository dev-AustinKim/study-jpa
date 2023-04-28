package com.example.expert.entity.registration;

import com.example.expert.audit.Period;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_CAR_REGISTRATION")
public class CarRegistration extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarOwner carOwner;
}



















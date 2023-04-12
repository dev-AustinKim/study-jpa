package com.example.basic.domain.entity;

import com.example.basic.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_SUPER_CAR")
@Getter @ToString
public class SuperCar {

    public SuperCar(){}

    @Id @GeneratedValue
    @Column(name = "SUEPER_CAR_ID")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SuperCarType superCarType;

    @NotNull
    private String name;

    @NotNull
    private String color;

    @NotNull
    private Long price;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd HH-mm-ss")
    private LocalDateTime releaseDate;
}

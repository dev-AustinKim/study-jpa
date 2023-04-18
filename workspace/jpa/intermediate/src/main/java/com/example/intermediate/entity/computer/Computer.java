package com.example.intermediate.entity.computer;

import com.example.intermediate.audit.Period;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_COMPUTER")
public class Computer extends Period {
    @Id @GeneratedValue
    private Long id;
    @NotNull private Integer screen;
    @NotNull private String brand;
    @NotNull private String name;
    @NotNull private Integer price;
    @NotNull private LocalDateTime releaseDate;
    @Embedded
    @NotNull private Hardware hardware;
}

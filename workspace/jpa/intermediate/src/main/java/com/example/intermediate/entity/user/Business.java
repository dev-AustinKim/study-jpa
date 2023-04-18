package com.example.intermediate.entity.user;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter @Setter @ToString(callSuper = true)
@Table(name = "TBL_BUSINESS")
public class Business extends User{
    @NotNull private String businessNumber;
}

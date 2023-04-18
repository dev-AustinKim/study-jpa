package com.example.intermediate.entity.employee;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PLANNER")
@Getter @Setter @ToString(callSuper = true)
@DynamicInsert
@DynamicUpdate
@DiscriminatorValue("pln")
public class Planner extends Employee {
    private Integer oa_level;
    @ColumnDefault(value = "0")
    private Integer clientCount;
}






















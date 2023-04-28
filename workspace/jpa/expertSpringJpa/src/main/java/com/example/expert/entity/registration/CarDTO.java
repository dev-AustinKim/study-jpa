package com.example.expert.entity.registration;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String carName;
    private Long carPrice;
    private LocalDateTime carReleaseDate;
    private CarStatusType carStatus;
    private int carOwnerCount;
}

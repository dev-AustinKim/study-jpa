package com.example.expert.entity.registration;

import com.example.expert.audit.Period;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @ToString(exclude = {"carRegistrations", "carOwner"})
@Table(name = "TBL_CAR")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String carName;
    @Enumerated(EnumType.STRING)
    @NotNull private CarType carBrand;
    @ColumnDefault(value = "0")
    private Long carPrice;
    @NotNull private LocalDateTime carReleaseDate;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatus; // 삭제 대신 상태 변경으로 설계

//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<CarOwner> carOwners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.PERSIST)
    List<CarRegistration> carRegistrations = new ArrayList<>();

//    자동차가 없는 차주는 DB에 저장되면 안될 때 cascade옵션을 준다.
//    왜냐하면, 자동차로 차주를 등록하기 때문이다.
    @ManyToOne(fetch = FetchType.LAZY/*, cascade = CascadeType.PERSIST*/)
    private CarOwner carOwner;

    @Builder
    public Car(String carName, CarType carBrand, Long carPrice, LocalDateTime carReleaseDate, CarStatusType carStatus) {
        this.carName = carName;
        this.carBrand = carBrand;
        this.carPrice = carPrice;
        this.carReleaseDate = carReleaseDate;
        this.carStatus = carStatus;
    }
}

















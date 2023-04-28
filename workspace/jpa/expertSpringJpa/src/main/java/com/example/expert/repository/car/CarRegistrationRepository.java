package com.example.expert.repository.car;

import com.example.expert.entity.registration.Car;
import com.example.expert.entity.registration.CarRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRegistrationRepository extends JpaRepository<CarRegistration, Long> {
    @Query("select c from Car c where c.id in (select c.car.id from CarRegistration c group by c.car.id having avg(c.carOwner.ownerAge) between 60 and 69)")
    public List<Car> findAllByAverageOfAge();
}

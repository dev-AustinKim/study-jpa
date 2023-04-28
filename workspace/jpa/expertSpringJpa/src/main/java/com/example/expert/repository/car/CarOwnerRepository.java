package com.example.expert.repository.car;

import com.example.expert.entity.registration.Car;
import com.example.expert.entity.registration.CarOwner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
//    차주는 무조건 다 나오고, 차주의 자동차까지 가져온다.
//    @Query("select distinct o from Car c left join c.carOwner o on c.carOwner.id = o.id")
//    public Page<CarOwner> findCarOwnerWithPaging(Pageable pageable);

//    차주는 무조건 다 나오고, 차주의 자동차까지 가져온다.
    @EntityGraph(attributePaths = "cars")
    public List<CarOwner> findAll();

//    자동차는 무조건 다 나오고, 자동차의 차주까지 가져온다.
    @Query("select distinct c from Car c left join c.carOwner o on c.carOwner.id = o.id")
    public Page<Car> findCarWithPaging(Pageable pageable);
}

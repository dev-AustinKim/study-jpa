package com.example.expert.repository.car;

import com.example.expert.entity.registration.Car;
import com.example.expert.entity.registration.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @EntityGraph(attributePaths = "carOwner")
    public List<Car> findAll();

    @Query("select new com.example.expert.entity.registration.CarDTO(c.id, c.carName, c.carPrice, c.carReleaseDate, c.carStatus, size(c.carRegistrations)) from Car c")
    public List<CarDTO> findAllWithCarOwnerCount();
}

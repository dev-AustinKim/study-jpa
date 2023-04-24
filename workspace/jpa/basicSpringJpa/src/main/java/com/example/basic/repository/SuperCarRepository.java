package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {
    public List<SuperCar> findByColorOrName(String color, String name);
    public List<SuperCar> findByNameLike(String name);

    @Query("select s from SuperCar s where s.type = com.example.basic.type.SuperCarType.LAMBORGHINI")
    public List<SuperCar> findAllByLamborghini();
}

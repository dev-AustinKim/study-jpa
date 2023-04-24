package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class SuperCarRepositoryTest {
    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest(){
        SuperCar superCar = SuperCar.builder()
                .name("아벤타도르")
                .color("핑크색")
                .releaseDate(LocalDateTime.now())
                .price(780_000_000.0)
                .type(SuperCarType.LAMBORGHINI)
                .build();

        superCarRepository.save(superCar);
    }

    @Test
    public void findByTypeLikeTest(){
        superCarRepository.findByNameLike("%아%").stream().map(SuperCar::toString).forEach(log::info);
    }
}





















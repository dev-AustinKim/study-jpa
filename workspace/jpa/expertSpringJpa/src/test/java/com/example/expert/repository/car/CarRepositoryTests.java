package com.example.expert.repository.car;

import com.example.expert.entity.registration.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class CarRepositoryTests {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarOwnerRepository carOwnerRepository;
    @Autowired
    private CarRegistrationRepository carRegistrationRepository;

//    자동차 100대 등록
    @Test
    public void saveTest(){
        String[] carNames = {"스파이더 588", "우라칸", "911", "E450", "Q6", "DBX", "520i"};
        CarType[] carTypes = {CarType.FERRARI, CarType.LAMBORGHINI, CarType.PORSCHE, CarType.BENZ, CarType.AUDI, CarType.ASTON_MARTIN, CarType.BMW};
        List<CarOwner> carOwners = new ArrayList<>();
        Random random = new Random();

        for(int i=0; i<20; i++){
            OwnerAddress ownerAddress = new OwnerAddress();
            ownerAddress.setOwnerAddress("경기도 평택시");
            ownerAddress.setOwnerAddressDetail(i + 1 + "번지");
            ownerAddress.setOwnerZipcode(String.valueOf(1234 + random.nextInt(10)));
            CarOwner carOwner = CarOwner.builder().ownerName("차주" + (i + 1))
                    .ownerAge(random.nextInt(81) + 20)
                    .ownerAddress(ownerAddress)
                    .carOwnerStatus(CarOwnerStatusType.ENABLE)
                    .build();
            carOwnerRepository.save(carOwner);
            carOwners.add(carOwner);
        }

        for(int i=0; i<100; i++){
            int idx = random.nextInt(7);
            Car car = Car.builder().carName(carNames[idx])
                    .carBrand(carTypes[idx])
                    .carPrice(700_000_000L)
                    .carReleaseDate(LocalDateTime.of(2021, random.nextInt(12) + 1, random.nextInt(28) + 1, 9, 00))
                    .carStatus(CarStatusType.ENABLE)
                    .build();

            if(goLottery(70)){

//                자동차에 당첨된 차주 이름 및 당첨된 차 대수 조회
//                SELECT O.OWNER_NAME, COUNT(C.ID) FROM TBL_CAR_OWNER O JOIN TBL_CAR C
//                ON O.ID = C.CAR_OWNER_ID
//                GROUP BY O.OWNER_NAME;
                CarOwner carOwner = carOwners.get(random.nextInt(carOwners.size()));
                car.setCarOwner(carOwner);
                CarRegistration carRegistration = new CarRegistration();
                carRegistration.setCar(car);
                carRegistration.setCarOwner(carOwner);
                carRegistrationRepository.save(carRegistration);
            }
            carRepository.save(car);
        }
    }

    private boolean goLottery(int rating){
        Random random = new Random();
        int[] arData = new int[10];
        for (int i=0; i<rating / 10; i++){
            arData[i] = 1;
        }
        return arData[random.nextInt(arData.length)] == 1;
    }

//    자동차 전체 정보 또는 차주 전체 정보 조회(페이징 처리)
    @Test
    public void findAllTest(){
//        carOwnerRepository.findCarOwnerWithPaging(PageRequest.of(0, 20))
//                .getContent().forEach(carOwner -> log.info(carOwner.getCars().toString()));
//        log.info("====================================" + carOwnerRepository.findCarOwnerWithPaging(PageRequest.of(0, 20))
//                .getContent().size());
//        carOwnerRepository.findCarOwnerWithPaging(PageRequest.of(0, 20))
//                .getContent().forEach(carOwner -> log.info("==============" + carOwner.getCars().size()));

//        log.info("====================================" + carOwnerRepository.findCarWithPaging(PageRequest.of(0, 100)).getContent().size());

//        log.info("====================================" + carOwnerRepository.findAll().size());
//        log.info("====================================" + carRepository.findAll().size());
//        carRepository.findAll().forEach(car -> log.info("====================================" + car.getCarOwner()));

    }


//    자동차 정보 전체와 차주 명 수 조회
    @Test
    public void setCarTest(){
        Random random = new Random();
        List<Car> cars = carRepository.findAll();
        List<CarOwner> carOwners = carOwnerRepository.findAll();
        int count = 0;

        for(int i=0; i<cars.size(); i++){
            Car car = cars.get(i);
            CarOwner carOwner = carOwners.get(random.nextInt(carOwners.size()));

            if(car.getCarOwner() != null) {
                if (car.getCarOwner().equals(carOwner)) {
                    continue;
                }
            }
            count ++;
            cars.get(i).setCarOwner(carOwner);

            CarRegistration carRegistration = new CarRegistration();
            carRegistration.setCarOwner(carOwner);
            carRegistration.setCar(car);
            carRegistrationRepository.save(carRegistration);

        }
        log.info("====================================" + count);
    }

    @Test
    public void findAllWithCarOwnerCountTest1(){
        carRepository.findAllWithCarOwnerCount().stream().map(CarDTO::toString).forEach(log::info);
    }
//    자동차 정보 전체와 차주 명 수 조회 후 차주 3명인 자동차 정보 전체 조회
    @Test
    public void findAllWithCarOwnerCountTest2(){
        carRepository.findAllWithCarOwnerCount().stream()
                .filter(carDTO -> carDTO.getCarOwnerCount() == 3)
                .map(CarDTO::toString)
                .forEach(log::info);
    }
//    차주의 평균 나이가 60대인 자동차 정보 전체 조회
    @Test
    public void findAllByAverageOfAgeTest(){
        carRegistrationRepository.findAllByAverageOfAge().forEach(car -> {
            log.info("========================" + car.getId());
            log.info("========================" + car.getCarOwner().getOwnerAge());
        });
    }

//    자동차 현재 차주의 나이가 90살 이상이면 자동차 폐차
    @Test
    public void updateTest(){
        carRepository.findAll().forEach(car -> {
            if(car.getCarOwner().getOwnerAge() >= 90){
                car.setCarStatus(CarStatusType.DISABLE);
            }
        });
    }
}















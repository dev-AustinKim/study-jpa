package com.example.intermediate.repository.user;

import com.example.intermediate.entity.user.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BusinessRepository extends JpaRepository<Business, Long> {
//    주소가 경기도인 기업회원은 아이디 끝에 9를 붙이기
    @Modifying(clearAutomatically = true)
    @Query("update Business b set b.userId = concat(b.userId, '9') where b.address = :address")
    public void updateUserIdByAddress(String address);
}

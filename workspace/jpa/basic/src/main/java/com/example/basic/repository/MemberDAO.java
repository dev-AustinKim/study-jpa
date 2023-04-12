package com.example.basic.repository;

import com.example.basic.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class MemberDAO {
//    1. application.yml파일에 작성된 Connection 정보를 통해 EntityManagerFactory가 실행된다.
//    2. EntityManagerFactory를 통해 EntityManager 객체가 생성된다.
    @PersistenceContext // EntityManager를 통해서 생성된 Entity 객체를 등록되는 영역
    private EntityManager entityManager; // EntityManagerFactory를 통해 생성되며, Connection 객체를 통해 SQL문을 제작해준다.
    
//    등록
//    항상 save를 하고 작업을 해야한다.
//    내가 등록을 하자마자 return을 해줘서 바로 담을 수 있게 해준다.
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

//    pk로 조회
//    Optional을 통해 null을 검사한다. Optional은 null일 수가 없기 때문에 NPE를 방지할 수 있으며,
//    필드로 들어간 엔티티의 NULL 검사를 편하게 할 수 있는 API이다. (그 안에 들어있는 것이 null일 수는 있다.)
//    단, Optional은 리턴 타입에서만 사용하는 것을 권장한다.
    public Optional<Member> findById(Long id) {
//        find에다가는 entity소속과 키 값을 써줘야한다.
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

//    삭제
//    이게 실행되면 Persistence애서도 삭제가 되고 쿼리도 나간다.
    public void delete(Member member) {
        entityManager.remove(member);
    }

}

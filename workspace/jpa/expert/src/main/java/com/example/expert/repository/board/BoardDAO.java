package com.example.expert.repository.board;

import com.example.expert.board.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public Board save(Board board){
        entityManager.persist(board);
        return board;
    }

//    조회
//    전체 조회
//    삭제

}

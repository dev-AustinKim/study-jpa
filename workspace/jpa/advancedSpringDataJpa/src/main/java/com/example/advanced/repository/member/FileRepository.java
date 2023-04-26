package com.example.advanced.repository.member;

import com.example.advanced.entity.member.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;

public interface FileRepository extends JpaRepository<File, Long> {
    @EntityGraph(attributePaths = "member") //JOIN 사용 됨, count query는 JOIN 없이 사용 됨
//    @Query("select f from File f") // JOIN 사용 안됨, count query는 JOIN 없이 사용 됨
//    @Query(value="select f.member from File f") // JOIN 사용 됨, count query도 JOIN 사용 됨(성능이 떨어짐)
//    @Query(value="select f.member from File f", countQuery="select count(f.id) from File f") // JOIN 사용 됨, count query는 직접 작성.
    public Page<File> findAll(@PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable);
}
























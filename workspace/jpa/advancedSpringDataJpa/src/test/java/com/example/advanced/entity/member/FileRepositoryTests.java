package com.example.advanced.entity.member;

import com.example.advanced.repository.member.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class FileRepositoryTests {
    @Autowired
    private FileRepository fileRepository;

    @Test
    public void saveTest(){
        File file = new File();
        Member member = new Member();
        MemberAddress memberAddress = new MemberAddress();

        memberAddress.setMemberAddress("서울시 강남구 청담동");
        memberAddress.setMemberAddressDetail("청담르엘 펜트하우스");
        memberAddress.setMemberPostcode("77777");

        member.setMemberId("hgd9999");
        member.setMemberPassword("9999");
        member.setMemberEmail("hgd9999@gmail.com");
        member.setMemberAddress(memberAddress);

        file.setFileName("땅문서.png");
        file.setFilePath("2023/04/25");
        file.setFileSize(2000L);
        file.setFileUuid(UUID.randomUUID().toString());
        file.setMember(member);

        fileRepository.save(file);
    }

    @Test
    public void findAllTest(){
        Page<File> filesPage = fileRepository.findAll(PageRequest.of(0, 1));
        filesPage.getContent().forEach(file -> log.info(file.getMember().getMemberEmail()));
        log.info("total: " + filesPage.getSize());
        log.info("total: " + filesPage.getTotalElements());
        log.info("total: " + filesPage.getTotalPages());
    }
}











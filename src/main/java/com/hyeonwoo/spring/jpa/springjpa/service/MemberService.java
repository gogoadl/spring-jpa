package com.hyeonwoo.spring.jpa.springjpa.service;


import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.MemberTest;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberInterface;
import com.hyeonwoo.spring.jpa.springjpa.repository.MemberRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.SpringMemberRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.SpringMemberTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final SpringMemberRepository springMemberRepository;
    private final SpringMemberTestRepository springMemberTestRepository;

    public void testSpringMember() {
        List<MemberInterface> test = springMemberRepository.findByInlineViewTest();
        List<MemberInterface> test2 = springMemberRepository.findByInlineViewTest2();
        List<MemberDto> test3 = springMemberRepository.findByInlineViewTest3();
        List<MemberDto> test4 = springMemberRepository.findByInlineViewTest4();

        log.info("[Spring JPA][Interface Projection] inline subquery with join");
        for (MemberInterface memberInterface : test) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }
        log.info("[Spring JPA][Interface Projection] join");
        for (MemberInterface memberInterface : test2) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }
        log.info("[Spring JPA][Class Projection] inline subquery with join");
        for (MemberDto memberDto : test3) {
            log.info(memberDto.toString());
        }
        log.info("[Spring JPA][Class Projection] join");
        for (MemberDto memberDto : test4) {
            log.info(memberDto.toString());
        }
        log.info(test.toString());
        // EXCEPTION
    }

    public void testMember() {
        List<MemberDto> test = memberRepository.findByInlineViewTest();
        List<MemberDto> test2 = memberRepository.findByInlineViewTest2();
        List<MemberDto> test3 = memberRepository.findByInlineViewTest3();
        List<MemberDto> test4 = memberRepository.findByInlineViewTest4();

        log.info("[Hibernate][DTO] inline subquery with join");
        for (MemberDto memberDto : test) {
            log.info(memberDto.toString());
        }
        log.info("[Hibernate][DTO] join");
        for (MemberDto memberDto : test2) {
            log.info(memberDto.toString());
        }
        log.info("[Hibernate][JPA style DTO] inline subquery with join");
        for (MemberDto memberDto : test3) {
            log.info(memberDto.toString());
        }
        log.info("[Hibernate][JPA style DTO] join");
        for (MemberDto memberDto : test4) {
            log.info(memberDto.toString());
        }

        log.info(test.toString());
        // EXCEPTION
    }

    @Transactional
    public void insertTestDataSet(Member a) {
        springMemberRepository.save(a);
    }

    @Transactional
    public void insertTestMemberDataSet(MemberTest a) {
        springMemberTestRepository.save(a);
    }

}

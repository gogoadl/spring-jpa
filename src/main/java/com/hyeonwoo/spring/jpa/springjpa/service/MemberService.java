package com.hyeonwoo.spring.jpa.springjpa.service;


import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.MemberTest;
import com.hyeonwoo.spring.jpa.springjpa.domain.Test;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberInterface;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.TestInterface;
import com.hyeonwoo.spring.jpa.springjpa.repository.MemberRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.SpringMemberRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.SpringMemberTestRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final TestRepository testRepository;
    public void testSpringMember() {

        PageRequest pageRequest = PageRequest.of(0, 5);
//        List<MemberDto> hqlTest = memberRepository.hqlTest();

//        Page<MemberInterface> findByMultipleJoinInlineViewParamTestPage = springMemberRepository.findByMultipleJoinInlineViewParamTestPage(1L, pageRequest);
//        log.info("[Spring JPA][Interface Projection] multiple Join inline subquery with join and param page");
//        for (MemberInterface memberInterface : findByMultipleJoinInlineViewParamTestPage) {
//            log.info(MemberDto.convertToDto(memberInterface).toString());
//        }

//        Page<TestInterface> pageRequestWithoutJoin = springMemberRepository.pageRequestWithoutJoin(1L, pageRequest);
//        log.info("[Spring JPA][Interface Projection] page request without join");
//        for (TestInterface testInterface : pageRequestWithoutJoin) {
//            log.info(MemberDto.convertToDto(testInterface).toString());
//        }

        Page<TestInterface> pageRequestWithoutSubQuery = springMemberRepository.pageRequestWithoutSubQuery(1L, pageRequest);
        log.info("[Spring JPA][Interface Projection] page request without subquery");
        for (TestInterface testInterface : pageRequestWithoutSubQuery) {
            log.info(MemberDto.convertToDto(testInterface).toString());
        }

        List<MemberInterface> findByMultipleJoinInlineViewParamTest = springMemberRepository.findByMultipleJoinInlineViewParamTest(1L);
        log.info("[Spring JPA][Interface Projection] multiple Join inline subquery with join and param");
        for (MemberInterface memberInterface : findByMultipleJoinInlineViewParamTest) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }

        List<MemberInterface> findByMultipleJoinInlineViewTest = springMemberRepository.findByMultipleJoinInlineViewTest();
        log.info("[Spring JPA][Interface Projection] multiple Join inline subquery with join");
        for (MemberInterface memberInterface : findByMultipleJoinInlineViewTest) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }

        List<MemberDto> findByMultipleJoinInlineViewTestDto = springMemberRepository.findByMultipleJoinInlineViewTestDto();
        log.info("[Spring JPA][Class Projection] multiple Join inline subquery with join");
        for (MemberDto memberDto : findByMultipleJoinInlineViewTestDto) {
            log.info(memberDto.toString());
        }

        List<MemberInterface> findByInlineViewTest = springMemberRepository.findByInlineViewTest();
        log.info("[Spring JPA][Interface Projection] inline subquery with join");
        for (MemberInterface memberInterface : findByInlineViewTest) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }

        List<MemberInterface> findByInlineViewTest2 = springMemberRepository.findByInlineViewTest2();
        log.info("[Spring JPA][Interface Projection] join");
        for (MemberInterface memberInterface : findByInlineViewTest2) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }

        List<MemberDto> findByInlineViewTest3 = springMemberRepository.findByInlineViewTest3();
        log.info("[Spring JPA][Class Projection] inline subquery with join");
        for (MemberDto memberDto : findByInlineViewTest3) {
            log.info(memberDto.toString());
        }

        List<MemberDto> findByInlineViewTest4 = springMemberRepository.findByInlineViewTest4();
        log.info("[Spring JPA][Class Projection] join");
        for (MemberDto memberDto : findByInlineViewTest4) {
            log.info(memberDto.toString());
        }

    }

    public void testMember() {

//        List<MemberDto> findByMultipleJoinInlineViewTest = memberRepository.findByMultipleJoinInlineViewTest();
//        log.info("[Hibernate][DTO] multiple join inline subquery with join");
//        for (MemberDto memberDto : findByMultipleJoinInlineViewTest) {
//            log.info(memberDto.toString());
//        }

        List<MemberDto> findByInlineViewTest = memberRepository.findByInlineViewTest();
        log.info("[Hibernate][DTO] inline subquery with join");
        for (MemberDto memberDto : findByInlineViewTest) {
            log.info(memberDto.toString());
        }

        List<MemberDto> findByInlineViewTest2 = memberRepository.findByInlineViewTest2();
        log.info("[Hibernate][DTO] join");
        for (MemberDto memberDto : findByInlineViewTest2) {
            log.info(memberDto.toString());
        }

        List<MemberDto> findByInlineViewTest3 = memberRepository.findByInlineViewTest3();
        log.info("[Hibernate][JPA style DTO] inline subquery with join");
        for (MemberDto memberDto : findByInlineViewTest3) {
            log.info(memberDto.toString());
        }

        List<MemberDto> findByInlineViewTest4 = memberRepository.findByInlineViewTest4();
        log.info("[Hibernate][JPA style DTO] join");
        for (MemberDto memberDto : findByInlineViewTest4) {
            log.info(memberDto.toString());
        }

    }

    @Transactional
    public void insertTestDataSet(Member a) {
        springMemberRepository.save(a);
    }

    @Transactional
    public void insertTestMemberDataSet(MemberTest a) {
        springMemberTestRepository.save(a);
    }
    @Transactional
    public void insertMemberDataSet(Member a) {
        springMemberRepository.save(a);
    }
    @Transactional
    public void insertTestDataSet(Test a) {
        testRepository.save(a);
    }

}

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
    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        // EXCEPTION
    }

    public void testSpringMember() {
        List<MemberInterface> test = springMemberRepository.findByInlineViewTest();
        List<MemberInterface> test2 = springMemberRepository.findByInlineViewTest2();
//        List<MemberDto> test3 = springMemberRepository.findByInlineViewTest3();
        List<MemberDto> test4 = springMemberRepository.findByInlineViewTest4();
        for (MemberInterface memberInterface : test) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }
        for (MemberInterface memberInterface : test2) {
            log.info(MemberDto.convertToDto(memberInterface).toString());
        }
//        for (MemberDto memberDto : test3) {
//            log.info(memberDto.toString());
//        }
        for (MemberDto memberDto : test4) {
            log.info(memberDto.toString());
        }
        log.info(test.toString());
        // EXCEPTION
    }

    public void testMember() {
        List<Member> test = memberRepository.findByInlineViewTest("박현우");
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

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

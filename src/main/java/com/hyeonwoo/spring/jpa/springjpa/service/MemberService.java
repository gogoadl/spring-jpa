package com.hyeonwoo.spring.jpa.springjpa.service;


import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.repository.MemberRepository;
import com.hyeonwoo.spring.jpa.springjpa.repository.SpringMemberRepository;
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
        List<Member> test = springMemberRepository.findByInlineViewTest("박현우");
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

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}

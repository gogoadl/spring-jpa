package com.hyeonwoo.spring.jpa.springjpa.repository;

import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberInterface;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    private final EntityManager em;

    public List<MemberDto> findByInlineViewTest() {
        return em.createQuery("SELECT T.id as id, T.testId as testId, T.name as name,T.address as address FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T", MemberDto.class)
                .getResultList();
    }
    public List<MemberDto> findByInlineViewTest2() {
        return em.createQuery("SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId", MemberDto.class)
                .getResultList();
    }
    public List<MemberDto> findByInlineViewTest3() {
        return em.createQuery("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T.id as id,T.name as name,T.address as address, T.testId as testId) FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T", MemberDto.class)
                .getResultList();
    }
    public List<MemberDto> findByInlineViewTest4() {
        return em.createQuery("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T2.id as id, MT.id as testId,T2.name as name,T2.address as address) FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId", MemberDto.class)
                .getResultList();
    }


}

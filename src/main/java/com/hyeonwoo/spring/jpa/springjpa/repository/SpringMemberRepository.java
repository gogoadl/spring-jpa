package com.hyeonwoo.spring.jpa.springjpa.repository;

import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringMemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT T.id as id,T.name as name,T.address as address, T.testId FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T")
    List<MemberInterface> findByInlineViewTest();

    @Query("SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId")
    List<MemberInterface> findByInlineViewTest2();

    @Query("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T.id as id,T.name as name,T.address as address, T.testId) FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T")
    List<MemberDto> findByInlineViewTest3();

    @Query("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T2.id as id, MT.id as testId,T2.name as name,T2.address as address) FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId")
    List<MemberDto> findByInlineViewTest4();
}

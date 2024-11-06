package com.hyeonwoo.spring.jpa.springjpa.repository;

import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.Test;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberInterface;
import com.hyeonwoo.spring.jpa.springjpa.domain.dto.TestInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringMemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT T.id as id,T.name as name,T.address as address, T.testId as testId, T.testName as testName FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address, T3.name as testName FROM Member T2, MemberTest MT, Test T3 WHERE :id = MT.memberId AND :id = T3.id) T")
    Page<MemberInterface> findByMultipleJoinInlineViewParamTestPage(@Param("id") Long id, PageRequest pageRequest);

    @Query("SELECT T.id as id,T.name as name,T.address as address FROM (SELECT T2.id as id, T2.name as name,T2.address as address FROM Member T2) T")
    Page<TestInterface> pageRequestWithoutJoin(@Param("id") Long id, PageRequest pageRequest);

    @Query("SELECT T.id as id,T.name as name,T.address as address FROM Member T")
    Page<TestInterface> pageRequestWithoutSubQuery(@Param("id") Long id, PageRequest pageRequest);

    @Query("SELECT T.id as id,T.name as name,T.address as address, T.testId as testId, T.testName as testName FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address, T3.name as testName FROM Member T2, MemberTest MT, Test T3 WHERE :id = MT.memberId AND :id = T3.id) T")
    List<MemberInterface> findByMultipleJoinInlineViewParamTest(@Param("id") Long id);

    @Query("SELECT T.id as id,T.name as name,T.address as address, T.testId as testId, T.testName as testName FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address, T3.name as testName FROM Member T2, MemberTest MT, Test T3 WHERE T2.id = MT.memberId AND T2.id = T3.id) T")
    List<MemberInterface> findByMultipleJoinInlineViewTest();

    @Query("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T.id as id,T.name as name, T.testName as testName, T.address as address, T.testId as testId) FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address, T3.name as testName FROM Member T2, MemberTest MT, Test T3 WHERE T2.id = MT.memberId AND T3.id = T2.id) T")
    List<MemberDto> findByMultipleJoinInlineViewTestDto();


    @Query("SELECT T.id as id,T.name as name,T.address as address, T.testId  as testId FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T")
    List<MemberInterface> findByInlineViewTest();

    @Query("SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId")
    List<MemberInterface> findByInlineViewTest2();

    @Query("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T.id as id,T.name as name,T.address as address, T.testId as testId) FROM (SELECT T2.id as id, MT.id as testId,T2.name as name,T2.address as address FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId) T")
    List<MemberDto> findByInlineViewTest3();

    @Query("SELECT new com.hyeonwoo.spring.jpa.springjpa.domain.dto.MemberDto(T2.id as id, MT.id as testId,T2.name as name,T2.address as address) FROM Member T2, MemberTest MT WHERE T2.id = MT.memberId")
    List<MemberDto> findByInlineViewTest4();
}

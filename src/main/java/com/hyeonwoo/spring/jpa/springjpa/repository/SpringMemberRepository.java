package com.hyeonwoo.spring.jpa.springjpa.repository;

import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringMemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT new Member(T.id as id,T.name as name,T.address as address) FROM (SELECT T2.id as id,T2.name as name,T2.address as address FROM Member T2 WHERE T2.id = 1) T")
    List<Member> findByInlineViewTest(@Param("name") String name);
}

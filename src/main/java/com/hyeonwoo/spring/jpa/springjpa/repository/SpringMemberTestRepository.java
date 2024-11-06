package com.hyeonwoo.spring.jpa.springjpa.repository;

import com.hyeonwoo.spring.jpa.springjpa.domain.MemberTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringMemberTestRepository extends JpaRepository<MemberTest, Long> {

}

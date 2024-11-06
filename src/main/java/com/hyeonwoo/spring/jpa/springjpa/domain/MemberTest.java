package com.hyeonwoo.spring.jpa.springjpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberTest {
    @Id @GeneratedValue
    @Column(name = "member_test_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    private String name;

    @Embedded
    private Address address;

}

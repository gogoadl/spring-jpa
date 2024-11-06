package com.hyeonwoo.spring.jpa.springjpa.domain.dto;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;

public interface MemberInterface {
    Long getId();
    String getName();
    Address getAddress();
    Long getTestId();
}

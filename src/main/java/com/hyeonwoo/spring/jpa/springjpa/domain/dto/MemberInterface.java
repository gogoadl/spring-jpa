package com.hyeonwoo.spring.jpa.springjpa.domain.dto;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;

public interface MemberInterface {
    Long getId();
    String getName();
    String getTestName();
    Address getAddress();
    Long getTestId();
}

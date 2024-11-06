package com.hyeonwoo.spring.jpa.springjpa.domain.dto;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    Long id;
    Long testId;
    String name;
    Address address;

    public static MemberDto convertToDto(MemberInterface member) {
        return new MemberDto(member.getId(), member.getTestId(), member.getName(), member.getAddress());
    }
}
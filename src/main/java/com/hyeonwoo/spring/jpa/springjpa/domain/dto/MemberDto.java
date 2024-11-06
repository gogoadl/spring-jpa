package com.hyeonwoo.spring.jpa.springjpa.domain.dto;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    Long id;
    Long testId;
    String name;
    String testName;
    Address address;

    public static MemberDto convertToDto(MemberInterface member) {
        return new MemberDto(member.getId(), member.getTestId(), member.getName(), member.getTestName(), member.getAddress());
    }

    public static MemberDto convertToDto(TestInterface member) {
        return new MemberDto(member.getId(), 0L, member.getName(),"test", member.getAddress());
    }
}

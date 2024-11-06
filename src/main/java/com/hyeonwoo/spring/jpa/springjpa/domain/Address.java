package com.hyeonwoo.spring.jpa.springjpa.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address { // 값 타입은 변경 불가능하게 설계해야 한다.
    private String city;
    private String street;
    private String zipCode;
    protected Address(){} // 임베디드 타입은 자바 기본 생성자를 public 또는 protected로 설정해야 한다.


    // Setter를 사용하지 않고 생성자에서 값을 모두 초기화 해서 변경 불가능한 클래스로 제공
    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", city, street, zipCode);
    }
}

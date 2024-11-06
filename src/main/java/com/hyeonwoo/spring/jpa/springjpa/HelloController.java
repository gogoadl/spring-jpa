package com.hyeonwoo.spring.jpa.springjpa;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
import com.hyeonwoo.spring.jpa.springjpa.domain.MemberTest;
import com.hyeonwoo.spring.jpa.springjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final MemberService memberService;
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }

    @GetMapping("test")
    public void test(Model model) {
        memberService.testMember();
    }

    @GetMapping("testMember")
    public void testMember(Model model) {
        memberService.testSpringMember();
    }

    @GetMapping("insert")
    public void insert() {
        MemberTest a = new MemberTest(1L, 1L,"박현우", new Address("Seoul", "Main Street", "12345"));
        MemberTest b = new MemberTest(2L, 2L,"차은우", new Address("Seoul", "Main Street", "12345"));
        MemberTest c = new MemberTest(3L, 3L,"장원영", new Address("Seoul", "Main Street", "12345"));
        MemberTest d = new MemberTest(4L,4L,"카리나", new Address("Seoul", "Main Street", "12345"));
        MemberTest e = new MemberTest(5L,5L,"홍윤기", new Address("Seoul", "Main Street", "12345"));

        memberService.insertTestMemberDataSet(a);
        memberService.insertTestMemberDataSet(b);
        memberService.insertTestMemberDataSet(c);
        memberService.insertTestMemberDataSet(d);
        memberService.insertTestMemberDataSet(e);
    }
}

package com.hyeonwoo.spring.jpa.springjpa;

import com.hyeonwoo.spring.jpa.springjpa.domain.Address;
import com.hyeonwoo.spring.jpa.springjpa.domain.Member;
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

    @GetMapping("insert")
    public void insert() {
        Member a = new Member(1L,"박현우", new Address("Seoul", "Main Street", "12345"));
        Member b = new Member(2L,"차은우", new Address("Seoul", "Main Street", "12345"));
        Member c = new Member(3L,"장원영", new Address("Seoul", "Main Street", "12345"));
        Member d = new Member(4L,"카리나", new Address("Seoul", "Main Street", "12345"));
        Member e = new Member(5L,"홍윤기", new Address("Seoul", "Main Street", "12345"));

        memberService.insertTestDataSet(a);
        memberService.insertTestDataSet(b);
        memberService.insertTestDataSet(c);
        memberService.insertTestDataSet(d);
        memberService.insertTestDataSet(e);
    }
}

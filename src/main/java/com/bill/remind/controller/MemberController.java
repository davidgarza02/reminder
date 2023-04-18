package com.bill.remind.controller;

import com.bill.remind.entity.Member;
import com.bill.remind.model.LoginRequest;
import com.bill.remind.service.MemberService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {
    //TODO:cambiar por requestObject
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping()
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping("/login")
    public Member login(@RequestBody LoginRequest loginRequest) {
        return memberService.login(loginRequest);
    }
}

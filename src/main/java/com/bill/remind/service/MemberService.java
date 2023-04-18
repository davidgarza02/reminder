package com.bill.remind.service;

import com.bill.remind.entity.Member;
import com.bill.remind.model.LoginRequest;
import com.bill.remind.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void addNewMember(Member member) {
        if (member != null)
            memberRepository.save(member);
    }

    public Member createMember(Member member) {
        if (member != null)
            return memberRepository.save(member);
        else
            throw new IllegalStateException("");

    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member login(LoginRequest req) {
        return memberRepository.findByUsernameAndPassword(req.getUsername(), req.getPassword()).orElseThrow(() ->
                new IllegalStateException("User with username " + req.getUsername() + "does not exist."));
    }
}

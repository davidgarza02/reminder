package com.bill.remind.service;

import com.bill.remind.controller.exception.InvalidCredentialsException;
import com.bill.remind.controller.exception.MemberIsNullException;
import com.bill.remind.entity.Member;
import com.bill.remind.model.LoginRequest;
import com.bill.remind.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        if (member != null)
            return memberRepository.save(member);
        else
            throw new MemberIsNullException();
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member login(LoginRequest req) {
        return memberRepository.findByUsernameAndPassword(req.getUsername(), req.getPassword())
                .orElseThrow(InvalidCredentialsException::new);
    }
}

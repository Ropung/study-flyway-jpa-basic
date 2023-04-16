package com.example.demo.member.service;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.types.AccountStatus;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.member.api.dto.MemberRegisterDto.MemberSignUpRequestDto;

@Service
@RequiredArgsConstructor
public final class DefaultMemberService implements MemberService {

    private final MemberRepository memberRepository;

    // @RequiredArgsConstructor가 해 주는 일(final, Not null인 애들)
//    public DefaultMemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public boolean signUp(MemberSignUpRequestDto dto) {
        Member member = Member.builder()
                .email(dto.email())
                .password(dto.rawPassword()) // FIXME hash it.
                .nickname(dto.nickname())
                .status(AccountStatus.ACTIVE)
                .build();

        memberRepository.save(member);

        return true; // or Exception before.
    }
}

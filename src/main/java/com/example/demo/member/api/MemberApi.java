package com.example.demo.member.api;

import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.example.demo.member.api.dto.MemberRegisterDto.MemberSignUpRequestDto;
import static com.example.demo.member.api.dto.MemberRegisterDto.MemberSignUpResponseDto;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public MemberSignUpResponseDto signUp(
            @RequestBody @Valid MemberSignUpRequestDto body,
            HttpServletRequest request
    ) {
        // ip example
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();

        return new MemberSignUpResponseDto( memberService.signUp(body) );
    }
}

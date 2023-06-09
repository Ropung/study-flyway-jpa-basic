package com.example.demo.member.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Pattern;

public record MemberRegisterDto() {
    public record MemberSignUpRequestDto(
            String email,
            @JsonProperty("password")
            @Pattern(
                    regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"
            )
            String rawPassword,
            String nickname
    ) {
        // 초깃값이나 예외 등을 줄 수 있음(소괄호 안 쓰는 생성자)
//        public MemberSignUpRequestDto {
//            if (email == null) email = "";
//            // ...
//        }
    }
    public record MemberSignUpResponseDto(
            boolean success
    ) {}
}

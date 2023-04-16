package com.example.demo.member.service;

import static com.example.demo.member.api.dto.MemberRegisterDto.MemberSignUpRequestDto;

public interface MemberService {
    // 파라미터는
    //  DTO 받아도 되고 Entity 받아도 됨(DTO -> Entity 변환 시점: Controller or Service)
    boolean signUp(MemberSignUpRequestDto dto);
}

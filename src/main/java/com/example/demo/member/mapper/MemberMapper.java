package com.example.demo.member.mapper;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.types.AccountStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.OffsetDateTime;

import static com.example.demo.member.api.dto.MemberRegisterDto.MemberSignUpRequestDto;

// ModelMapper -> 리플렉션이 적용됨(내부적으로)
// MapStruct -> AnnotationProcessor로 컴파일타임에 모두 준비

@Mapper(componentModel = "spring")
public interface MemberMapper {
//    @Mappings(
//            @Mapping(target = "password", source = "password"),
//            @Mapping(target = "거시기", source = "dto.머시기")
//    )
    Member from(MemberSignUpRequestDto dto, String password, AccountStatus status, OffsetDateTime createdAt);
}

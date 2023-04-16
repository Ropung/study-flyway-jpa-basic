package com.example.demo.member.entity;

import com.example.demo.member.entity.types.AccountStatus;
import com.example.demo.support.MySchemaConstants;
import com.example.demo.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

import static com.example.demo.support.Constants.DEFAULT_TIMEZONE_ID;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        name = MySchemaConstants.TB_MEMBER,
        // (원래는 생략 가능) 스키마 구분할 때는 스키마 이름을 명시함.
        schema = MySchemaConstants.SCHEMA,
        catalog = MySchemaConstants.SCHEMA
)
// 그 외 대부분 Flyway에 의해서 생성하니까, JPA에 의한 생성을 위한 애노테이션 등은 대부분 생략되고 삭제되어도 됨.
public class Member extends UuidBaseEntity {
    @Column /* (length = 30, nullable = false) */
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
}

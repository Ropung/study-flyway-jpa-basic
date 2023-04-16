package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// @Repository 애노테이션 없어도 됨.
public interface MemberRepository extends JpaRepository<Member, UUID> {

}

package com.hello.sevlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void save(){
        //given
        Member hello = new Member("Hello", 13);
        //when
        Member savedMember = memberRepository.save(hello);
        //then
        Member findMember = memberRepository.findById(hello.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }
    @Test
    void findAll(){
        //given
        Member mem1 = memberRepository.save(new Member("mem1", 20));
        Member mem2 = memberRepository.save(new Member("mem2", 30));
        //when
        List<Member> members = memberRepository.findAll();

        //then
        Assertions.assertThat(members).hasSize(2);
        Assertions.assertThat(members).contains(mem1, mem2);

    }
}
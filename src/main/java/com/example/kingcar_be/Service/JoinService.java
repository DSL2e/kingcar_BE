package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.MemberIdResponse;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Exception.ErrorCode;
import com.example.kingcar_be.Exception.NameDuplicationException;
import com.example.kingcar_be.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberRepository memberRepository;
    public MemberIdResponse join(String nickname){

        if(memberRepository.existsByNickname(nickname))
            throw new NameDuplicationException(ErrorCode.INVALID_REQUEST,"중복된 닉네임입니다");

        Member newMember = new Member(nickname);
        memberRepository.save(newMember);
        return MemberIdResponse.builder().memberId(newMember.getMemberId()).build();
    }
}

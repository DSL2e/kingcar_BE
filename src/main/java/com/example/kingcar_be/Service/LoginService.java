package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.MemberIdResponse;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Exception.ErrorCode;
import com.example.kingcar_be.Exception.NameDuplicationException;
import com.example.kingcar_be.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public MemberIdResponse login(String nickname){
        if(!memberRepository.existsByNickname(nickname))
            throw new NameDuplicationException(ErrorCode.INVALID_REQUEST,"없는 닉네임입니다");

        Member member = memberRepository.findByNickname(nickname);
        return MemberIdResponse.builder().memberId(member.getMemberId()).build();
    }

}

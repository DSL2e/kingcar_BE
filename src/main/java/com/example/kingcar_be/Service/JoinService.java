package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.JoinRequest;
import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepository joinRepository;
    public Status join(String nickname){
        Member newMember = new Member(nickname);
        joinRepository.save(newMember);
        return Status.builder().status("ok").build();
    }
}

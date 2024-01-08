package com.example.kingcar_be.Service;


import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class CarModelService {
    private final MemberRepository memberRepository;

    public Status register(Long memberId, String model){
        Member target = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));

        target.registerModel(model);
        return Status.builder().status("ok").build();
    }

}

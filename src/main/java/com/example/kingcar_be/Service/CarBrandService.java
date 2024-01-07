package com.example.kingcar_be.Service;

import com.example.kingcar_be.DTO.Status;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CarBrandService {
    private final MemberRepository memberRepository;

    public Status register(Long memberId, String brand){
        Member target = memberRepository.findById(memberId).orElseThrow();
        target.registerBrand(brand);
        return Status.builder().status("ok").build();
    }


}

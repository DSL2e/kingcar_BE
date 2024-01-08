package com.example.kingcar_be.Repository;

import com.example.kingcar_be.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNickname(String nickname);
    Member findByNickname(String nickname);
}

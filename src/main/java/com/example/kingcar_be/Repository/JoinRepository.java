package com.example.kingcar_be.Repository;

import com.example.kingcar_be.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinRepository extends JpaRepository<Member, Long> {
}

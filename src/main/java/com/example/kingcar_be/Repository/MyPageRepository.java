package com.example.kingcar_be.Repository;


import com.example.kingcar_be.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPageRepository extends JpaRepository<Member, Long> {
}

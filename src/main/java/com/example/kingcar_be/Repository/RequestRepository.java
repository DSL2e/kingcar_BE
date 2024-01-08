package com.example.kingcar_be.Repository;

import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.Member;
import com.example.kingcar_be.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query("select r from Request r where r.from.memberId = :fromId and r.to.memberId = :toId and r.article.articleId = :articleId")
    List<Request> findByFromToArticle(Long fromId, Long toId, Long articleId);

    List<Request> findAllByArticleArticleId(Long articleId);
}

package com.example.kingcar_be.Repository;

import com.example.kingcar_be.DTO.ArticleElement;
import com.example.kingcar_be.Entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Slice<ArticleElement> findAllByOrderByArticleIdDesc(Pageable page);
}

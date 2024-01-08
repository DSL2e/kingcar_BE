package com.example.kingcar_be.Repository;

import com.example.kingcar_be.DTO.ArticleDetail;
import com.example.kingcar_be.Entity.Article;
import com.example.kingcar_be.Entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDetailRepository extends JpaRepository<Article, Long> {
}

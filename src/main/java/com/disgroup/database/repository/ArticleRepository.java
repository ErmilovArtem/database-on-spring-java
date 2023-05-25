package com.disgroup.database.repository;

import com.disgroup.database.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByOrderByIdAsc();

    List<Article> findByOrderByIdDesc();

    List<Article> findByOrderByProductIdAsc();

    List<Article> findByOrderByProductIdDesc();

    List<Article> findByOrderByTitleAsc();

    List<Article> findByOrderByContentAsc();

    List<Article> findByOrderByContentDesc();

    List<Article> findByOrderByCreationDateAsc();

    List<Article> findByOrderByCreationDateDesc();

    List<Article> findByTitleContainingIgnoreCase(String keyword);
}


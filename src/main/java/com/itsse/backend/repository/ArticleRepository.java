package com.itsse.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsse.backend.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}

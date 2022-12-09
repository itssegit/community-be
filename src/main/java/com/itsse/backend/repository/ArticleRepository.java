package com.itsse.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsse.backend.entity.Article;
import com.itsse.backend.entity.User;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> getArticlesByAuthor(User author);
}

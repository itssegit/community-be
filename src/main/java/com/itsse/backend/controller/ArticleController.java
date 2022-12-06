package com.itsse.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsse.backend.dto.ArticleDto;
import com.itsse.backend.entity.Article;
import com.itsse.backend.entity.User;
import com.itsse.backend.repository.ArticleRepository;
import com.itsse.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    //
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/register")
    public void registerArticle(@RequestBody ArticleDto article) {
        //
        //1. author 검색
        User author = userRepository.getByUid(article.getAuthor());
        
        //2. 저장할 Article 정보 setting
        Article articleToSave = new Article();
        articleToSave.setAuthor(author);
        articleToSave.setTitle(article.getTitle());
        articleToSave.setContents(article.getContent());
        
        articleRepository.save(articleToSave);
    }
}

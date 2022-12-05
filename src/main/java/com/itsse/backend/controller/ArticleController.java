package com.itsse.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    //
    @PostMapping("/register")
    public void registerArticle(@RequestBody String content) {
        System.out.println(content);
        System.out.println("register article method in java");
    }
}

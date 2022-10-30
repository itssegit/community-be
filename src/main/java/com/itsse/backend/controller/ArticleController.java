package com.itsse.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    //
    @PostMapping("/register")
    public void registerArticle(HttpServletResponse response) {
        System.out.println(response);
        System.out.println("register article method in java");
    }
}

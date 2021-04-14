package com.stackroute.articleRecommendationService.controller;

import com.stackroute.articleRecommendationService.model.Article;
import com.stackroute.articleRecommendationService.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ArticleRecommendationController {

    @Autowired
    private ArticleService articleService;



    @GetMapping(value="/articles")
    public ResponseEntity<?> getArticles() {
        List<Article> articleList= articleService.getRecommendedArticle();
//        if(articleList==null) {
//            return new ResponseEntity<List<Article>>(articleList, HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<List<Article>>(articleList,HttpStatus.OK);
    }



}

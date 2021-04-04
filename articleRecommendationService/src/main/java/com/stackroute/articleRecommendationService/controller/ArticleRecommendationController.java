package com.stackroute.articleRecommendationService.controller;

import com.stackroute.articleRecommendationService.model.Headlines;
import com.stackroute.articleRecommendationService.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ArticleRecommendationController {

    @Autowired
    private ArticleService articleService;



    @GetMapping(value="/articles",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getArticles(HttpServletRequest request) {

        Headlines headlines= articleService.getRecommendedArticle();
        if(headlines==null) {
            return new ResponseEntity<Headlines>(headlines, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Headlines>(headlines,HttpStatus.OK);
    }



}

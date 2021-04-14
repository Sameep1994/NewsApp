package com.stackroute.articleRecommendationService.repository;

import com.stackroute.articleRecommendationService.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ArticleRepository extends MongoRepository<Article,String> {

    List<Article> findAll();

}

package com.stackroute.articleRecommendationService.repository;

import com.stackroute.articleRecommendationService.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ArticleRepository extends MongoRepository<Article,Integer> {

}

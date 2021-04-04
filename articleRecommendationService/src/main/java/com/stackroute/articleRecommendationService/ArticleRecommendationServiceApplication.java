package com.stackroute.articleRecommendationService;

import com.stackroute.articleRecommendationService.repository.ArticleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ArticleRepository.class)
@EnableAutoConfiguration
public class ArticleRecommendationServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ArticleRecommendationServiceApplication.class, args);
	}

}


package com.stackroute.articleRecommendationService.service;

import com.stackroute.articleRecommendationService.model.Headlines;
import com.stackroute.articleRecommendationService.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class ArticleService {
    @Autowired
    private ArticleRepository repository;



    public Headlines getRecommendedArticle(){
        String url ="https://newsapi.org/v2/top-headlines?country=in&apiKey=095c7c85397b4512998e482add62b2f6";
        Headlines resp = null;
        RestTemplate restTemplate = new RestTemplate();
        resp = restTemplate.getForObject(url,Headlines.class);
        repository.saveAll(resp.getArticles());
        return resp;
    }


}

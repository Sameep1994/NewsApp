package com.stackroute.articleRecommendationService;

import com.stackroute.articleRecommendationService.repository.ArticleRepository;
import com.stackroute.articleRecommendationService.service.ArticleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;


public class ArticleServiceTest {


    @InjectMocks
    private ArticleService articleService;

    @Mock
    ArticleRepository repository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void TestArticleService(){
        when(repository.saveAll(anyCollection())).thenReturn(anyList());
        Assert.assertNotNull(articleService.getRecommendedArticle());
    }
}

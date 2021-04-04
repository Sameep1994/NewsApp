package com.stackroute.articleRecommendationService.model;

import java.util.List;

public class Headlines {
    private int totalResults;
    private List<Article> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Headlines{" +
                "totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }
}

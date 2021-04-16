package com.stackroute.favouriteservice.service;

import com.stackroute.favouriteservice.model.Article;
import com.stackroute.favouriteservice.repository.FavouriteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    public Boolean setFavourite(ObjectId id){
       Article favArticle = favouriteRepository.findById(id);
       if(favArticle==null){
           return false;
       }
       favArticle.setIsAdded("true");
       favouriteRepository.save(favArticle);
       return true;
    }

    public Boolean removeFavourite(ObjectId id){
        Article favArticle = favouriteRepository.findById(id);
        if(favArticle==null){
            return false;
        }
        favArticle.setIsAdded("false");
        favouriteRepository.save(favArticle);
        return true;
    }

    public List<Article> getAllFavourites(){
        List<Article> favArticles = favouriteRepository.findAllByisAdded("true");
        return favArticles;
    }

}

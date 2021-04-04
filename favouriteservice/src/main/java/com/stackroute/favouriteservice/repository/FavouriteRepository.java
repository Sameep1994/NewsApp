package com.stackroute.favouriteservice.repository;

import com.stackroute.favouriteservice.model.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface FavouriteRepository extends MongoRepository<Article,String> {
    Article findById(ObjectId id);
    @Query("{isAdded : ?0}")
    List<Article> findAllByisAdded(String isAdded);
}

package com.stackroute.favouriteservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.favouriteservice.model.Article;
import com.stackroute.favouriteservice.service.FavouriteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping(value = "favourite/{id}")
    public ResponseEntity<?> setFavourite(@PathVariable("id") Object id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = id.toString();
        ObjectId objectId=mapper.convertValue(s,ObjectId.class);

        Boolean isFavSet = favouriteService.setFavourite(objectId);
        return new ResponseEntity<Boolean>(isFavSet, HttpStatus.OK);
    }

    @PostMapping(value="removefavourite/{id}")
    public  ResponseEntity<?> removeFavourite(@PathVariable("id") Object id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = id.toString();
        ObjectId objectId=mapper.convertValue(s,ObjectId.class);

        Boolean isFavSet = favouriteService.setFavourite(objectId);
        return new ResponseEntity<Boolean>(isFavSet, HttpStatus.OK);
    }

    @GetMapping("/getAllFavourites")
    public ResponseEntity<?> getAllFavourites(){
        List<Article> articles =favouriteService.getAllFavourites();
        return new ResponseEntity<List<Article>>(articles,HttpStatus.OK);
    }
}

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
@CrossOrigin(origins = "http://localhost:4200")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @RequestMapping(value = "favourite/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> setFavourite(@PathVariable("id") String id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectId objectId=mapper.readValue(id,ObjectId.class);

        Boolean isFavSet = favouriteService.setFavourite(objectId);
        return new ResponseEntity<Boolean>(isFavSet, HttpStatus.OK);
    }

    @GetMapping("/getAllFavourites")
    public ResponseEntity<?> getAllFavourites(){
        List<Article> articles =favouriteService.getAllFavourites();
        return new ResponseEntity<List<Article>>(articles,HttpStatus.OK);
    }
}

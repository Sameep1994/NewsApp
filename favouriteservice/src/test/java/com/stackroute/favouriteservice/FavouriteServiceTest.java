package com.stackroute.favouriteservice;

import com.stackroute.favouriteservice.repository.FavouriteRepository;
import com.stackroute.favouriteservice.service.FavouriteService;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class FavouriteServiceTest {

    @InjectMocks
    private FavouriteService favouriteService;

    @Mock
    FavouriteRepository favouriteRepository;

    private ObjectId objectId;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestFavouriteService(){
        when(favouriteRepository.findAllByisAdded(anyString())).thenReturn(anyList());
        Assert.assertNotNull(favouriteService.getAllFavourites());
    }

    @Test
    public void TestAddFavourite(){

        Assert.assertNotNull(favouriteService.setFavourite(any(ObjectId.class)));
    }
}

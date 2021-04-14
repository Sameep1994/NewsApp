package com.stackroute.favouriteservice;

import com.stackroute.favouriteservice.repository.FavouriteRepository;
import com.stackroute.favouriteservice.service.FavouriteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class FavouriteServiceTest {

    @InjectMocks
    private FavouriteService favouriteService;

    @Mock
    FavouriteRepository favouriteRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestFavouriteService(){
        when(favouriteRepository.findAllByisAdded(anyString())).thenReturn(anyList());
        Assert.assertNotNull(favouriteService.getAllFavourites());
    }
}

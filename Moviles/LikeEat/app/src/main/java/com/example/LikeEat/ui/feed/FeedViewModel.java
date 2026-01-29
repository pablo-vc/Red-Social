package com.example.LikeEat.ui.feed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.LikeEat.R;
import com.example.LikeEat.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FeedViewModel extends ViewModel {


    private final MutableLiveData<List<Restaurant>> restaurants = new MutableLiveData<>();
    private final MutableLiveData<List<Restaurant>> likedRestaurants = new MutableLiveData<>();

    public FeedViewModel() {
        restaurants.setValue(new ArrayList<>());
        likedRestaurants.setValue(new ArrayList<>());
    }

    public LiveData<List<Restaurant>> getRestaurants() {
        return restaurants;
    }

    public LiveData<List<Restaurant>> getLikedRestaurants() {
        return likedRestaurants;
    }

    public void addLiked(Restaurant r) {
        List<Restaurant> currentLikes = likedRestaurants.getValue();
        currentLikes.add(r);
        likedRestaurants.setValue(currentLikes);
    }

    public void cargarMockRestaurants() {
        List<Restaurant> list = new ArrayList<>();

        list.add(new Restaurant("Pizza Place", R.drawable.restaurant1, "Prueba", "Prueba", "Prueba"));
        list.add(new Restaurant("Sushi Bar", R.drawable.restaurant2, "Prueba", "Prueba"));
        list.add(new Restaurant("Burger House", R.drawable.restaurant3));
        list.add(new Restaurant("Burger House", R.drawable.restaurant3, "Prueba"));

        restaurants.setValue(list);
    }

}

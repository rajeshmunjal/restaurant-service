package com.ibm.service;

import java.util.List;


import com.ibm.model.Restaurant;

public interface RestaurantService {
    void createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByName(String name);
    List<Restaurant> getAllRestaurants();

}

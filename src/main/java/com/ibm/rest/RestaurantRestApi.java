package com.ibm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ibm.model.MenuItem;
import com.ibm.model.Restaurant;
import com.ibm.service.MenuItemService;
import com.ibm.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantRestApi {
    RestaurantService restaurantService;
    MenuItemService menuItemService;

    @Autowired
    public RestaurantRestApi(RestaurantService restaurantService, MenuItemService menuItemService) {
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Restaurant findRestaurant(@RequestParam(value = "name") String name) {
        return restaurantService.getRestaurantByName(name);
    }
    @RequestMapping(value = "/restaurants/all", method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    
    @RequestMapping(value = "/restaurants/{rid}/menuItems", method = RequestMethod.GET)
    public List<MenuItem> getMenuItems(@PathVariable String rid) {
        return menuItemService.findAllByRestaurantId(rid);
    }

    @RequestMapping(value = "/restaurants/{rid}/menuItems", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
    }

    @RequestMapping(value = "/restaurants/bulk/menuItems", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItems) {
        this.menuItemService.uploadMenuItems(menuItems);
    }
}

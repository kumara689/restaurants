package org.gov.tech.restaurants.dto;

import lombok.Data;
import org.gov.tech.restaurants.model.Restaurant;
import org.springframework.beans.BeanUtils;

@Data
public class RestaurantDto {
    private String id;
    private String name;
    private String location;
    private String sessionId;

    public static RestaurantDto modelToDto(Restaurant restaurant){
        RestaurantDto restaurantDto = new RestaurantDto();
        BeanUtils.copyProperties(restaurant, restaurantDto);
        return restaurantDto;
    }

    public static Restaurant dtoToModel(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        return restaurant;
    }
}

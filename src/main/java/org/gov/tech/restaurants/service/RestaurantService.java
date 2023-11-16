package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.RestaurantDto;
import org.gov.tech.restaurants.model.Restaurant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RestaurantService {
    Flux<RestaurantDto> streamAllRestaurants();

    Mono<RestaurantDto> saveRestaurant(Mono<RestaurantDto> restaurantDto);

    Flux<RestaurantDto> getRestaurantsBySessionId(String sessionId);

    Mono<RestaurantDto> pickRandomRestaurant();
}

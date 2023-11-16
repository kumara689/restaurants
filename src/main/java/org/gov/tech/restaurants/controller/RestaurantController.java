package org.gov.tech.restaurants.controller;

import org.gov.tech.restaurants.dto.RestaurantDto;
import org.gov.tech.restaurants.service.RestaurantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<RestaurantDto> createRestaurant(@RequestBody Mono<RestaurantDto> restaurantDto){
        return restaurantService.saveRestaurant(restaurantDto);
    }

    @GetMapping
    public Flux<RestaurantDto> loadAllRestaurants(){
        return restaurantService.streamAllRestaurants();
    }

    @GetMapping("/{sessionId}")
    public Flux<RestaurantDto> getRestaurantsBySessionId(@PathVariable String sessionId){
        return restaurantService.getRestaurantsBySessionId(sessionId);
    }

    @GetMapping(path = "/random")
    public Mono<RestaurantDto> pickRandomRestaurant(){
        return restaurantService.pickRandomRestaurant();
    }
}

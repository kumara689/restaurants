package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.RestaurantDto;
import org.gov.tech.restaurants.model.Restaurant;
import org.gov.tech.restaurants.repo.RestaurantRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Flux<RestaurantDto> streamAllRestaurants() {
        return restaurantRepository.findAll().map(RestaurantDto::modelToDto);
    }

    @Override
    public Mono<RestaurantDto> saveRestaurant(Mono<RestaurantDto> restaurantDto) {
        return restaurantDto.map(RestaurantDto::dtoToModel)
                .flatMap(restaurantRepository::insert)
                .map(RestaurantDto::modelToDto);
    }

    @Override
    public Flux<RestaurantDto> getRestaurantsBySessionId(String sessionId) {
        return restaurantRepository.findBySessionId(sessionId).map(RestaurantDto::modelToDto);
    }

    @Override
    public Mono<RestaurantDto> pickRandomRestaurant() {
        return restaurantRepository.findAll().collectList().map(list -> {
            Restaurant restaurant = null;
            if(!list.isEmpty()) {
                Random random = new Random();
                restaurant = list.get(random.nextInt(list.size()));
            }
            return Mono.justOrEmpty(RestaurantDto.modelToDto(restaurant));
        }).flatMap(mono -> mono);
    }


}

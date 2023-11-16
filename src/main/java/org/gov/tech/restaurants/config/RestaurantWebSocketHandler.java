package org.gov.tech.restaurants.config;

import org.gov.tech.restaurants.dto.RestaurantDto;
import org.gov.tech.restaurants.service.RestaurantService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RestaurantWebSocketHandler implements WebSocketHandler {

    private final Flux<RestaurantDto> restaurantDtoFlux;

    public RestaurantWebSocketHandler(RestaurantService restaurantService) {
        this.restaurantDtoFlux = restaurantService.streamAllRestaurants().share();
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> messageFlux = restaurantDtoFlux.map(restaurant ->
                session.textMessage("Restaurant updated: " + restaurant.getName()));

        return session.send(messageFlux);
    }
}

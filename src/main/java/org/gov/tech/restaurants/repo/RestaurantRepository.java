package org.gov.tech.restaurants.repo;

import org.gov.tech.restaurants.model.Restaurant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RestaurantRepository extends ReactiveMongoRepository<Restaurant, String> {
    Flux<Restaurant> findBySessionId(String sessionId);
}

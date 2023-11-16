package org.gov.tech.restaurants.repo;

import org.gov.tech.restaurants.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}

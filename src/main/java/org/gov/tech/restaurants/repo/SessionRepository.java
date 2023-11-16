package org.gov.tech.restaurants.repo;

import org.gov.tech.restaurants.model.Session;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SessionRepository extends ReactiveMongoRepository<Session, String> {
}

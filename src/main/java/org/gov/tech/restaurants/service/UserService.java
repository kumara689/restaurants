package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.UserDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> createUser(Mono<UserDto> userDto);
}

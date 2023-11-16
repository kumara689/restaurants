package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.UserDto;
import org.gov.tech.restaurants.repo.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Mono<UserDto> createUser(Mono<UserDto> userDto) {
        return userDto.map(UserDto::dtoToModel)
                .flatMap(userRepository::insert)
                .map(UserDto::modelToDto);
    }
}

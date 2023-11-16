package org.gov.tech.restaurants.controller;

import org.gov.tech.restaurants.dto.UserDto;
import org.gov.tech.restaurants.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDto) {
        return userService.createUser(userDto);
    }
}

package org.gov.tech.restaurants.controller;

import org.gov.tech.restaurants.dto.SessionDto;
import org.gov.tech.restaurants.service.SessionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "http://localhost:5173")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping
    public Mono<SessionDto> initiateSession(@RequestBody SessionDto sessionDto) {
        return sessionService.initiateSession(sessionDto.getInitiatedBy(), sessionDto.getInvitedUsers());
    }

    @DeleteMapping("/{sessionId}")
    public Mono<Void> endSession(@PathVariable String sessionId) {
        return sessionService.endSession(sessionId);
    }
}

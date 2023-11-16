package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.SessionDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SessionService {
    Mono<SessionDto> initiateSession(String initiatorUserId, List<String> invitedUserIds);
    Mono<Void> endSession(String sessionId);
}

package org.gov.tech.restaurants.service;

import org.gov.tech.restaurants.dto.SessionDto;
import org.gov.tech.restaurants.model.Session;
import org.gov.tech.restaurants.repo.SessionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }
    @Override
    public Mono<SessionDto> initiateSession(String initiatorUserId, List<String> invitedUserIds) {
        Session session = new Session();
        session.setInitiatedBy(initiatorUserId);
        session.getInvitedUsers().addAll(invitedUserIds);
        session.setActive(Boolean.TRUE);
        return sessionRepository.save(session).map(SessionDto::modelToDto);
    }

    @Override
    public Mono<Void> endSession(String sessionId) {
        return sessionRepository.deleteById(sessionId);
    }
}

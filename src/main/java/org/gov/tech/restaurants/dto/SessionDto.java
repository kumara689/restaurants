package org.gov.tech.restaurants.dto;

import lombok.Data;
import org.gov.tech.restaurants.model.Session;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class SessionDto {
    private String id;
    private String initiatedBy;
    private List<String> invitedUsers = new ArrayList<>(0);
    private boolean active;

    public static SessionDto modelToDto(Session session){
        SessionDto sessionDto = new SessionDto();
        BeanUtils.copyProperties(session, sessionDto);
        return sessionDto;
    }

    public static Session dtoToModel(SessionDto sessionDto){
        Session session = new Session();
        BeanUtils.copyProperties(sessionDto, session);
        return session;
    }
}

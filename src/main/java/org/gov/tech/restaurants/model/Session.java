package org.gov.tech.restaurants.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "SESSION")
public class Session implements Serializable {

    @Serial
    private static final long serialVersionUID = -8119676020267090550L;

    @Id
    private String id;
    private String initiatedBy;
    private List<String> invitedUsers = new ArrayList<>(0);
    private boolean active;
}

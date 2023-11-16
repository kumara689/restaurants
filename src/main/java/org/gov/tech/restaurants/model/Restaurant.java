package org.gov.tech.restaurants.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Document(collection = "RESTAURANT")
public class Restaurant implements Serializable {

    @Serial
    private static final long serialVersionUID = -4369789340990317061L;

    @Id
    private String id;

    private String name;

    private String location;

    private String sessionId;
}

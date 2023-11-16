package org.gov.tech.restaurants.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Document(collection = "USER")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 7147734680542844399L;

    @Id
    private String id;
    private String name;

}

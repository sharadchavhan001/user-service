package com.app.product_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id") // Exclude id field from toString output for better readability.
@EqualsAndHashCode(exclude = "id") // Exclude id field from equals and hashCode methods for better performance.
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore any unknown properties during JSON parsing.
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String mobile;
}

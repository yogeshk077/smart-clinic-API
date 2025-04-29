package com.smartclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "User";
    @Id
    private Long id;
    private String username;
    private String password;

    private Role role;
    private boolean active = true;
    // getters and setters
}

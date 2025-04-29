package com.smartclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection = "Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    // getters and setters
}
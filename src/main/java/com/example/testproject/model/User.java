package com.example.testproject.model;

import com.example.testproject.model.enums.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_user")
public class User {


    @Id
            @GeneratedValue
    Long id;
    String name;
    String imageUri;

    String email;
    @Enumerated(EnumType.STRING)
    Status status;
}

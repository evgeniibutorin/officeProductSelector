package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String login;

    String password;

    Status status;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "user" )
    List<Mark> marks;

    public boolean isAdmin() {
        return Status.ADMIN.equals(this.status);
    }

}

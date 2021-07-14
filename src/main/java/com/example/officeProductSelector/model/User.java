package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.*;

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

//    @OneToMany
//    List<Comment> comments;
//
//    @OneToMany
//    List<Mark> marks;

}

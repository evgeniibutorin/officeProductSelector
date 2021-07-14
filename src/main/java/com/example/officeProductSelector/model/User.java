package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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

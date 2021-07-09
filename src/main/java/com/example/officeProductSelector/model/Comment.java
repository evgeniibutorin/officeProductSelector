package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {
    @Id
    Integer id;

    String comment;

    @ManyToOne
    Product product;

    @ManyToOne
    User user;

}

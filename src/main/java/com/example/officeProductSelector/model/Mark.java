package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
public class Mark {
    @Id
    Integer id;

    int mark;

    @ManyToOne
    Product product;

    @ManyToOne
    User user;
}

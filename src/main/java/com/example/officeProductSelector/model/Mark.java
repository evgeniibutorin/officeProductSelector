package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Mark {
    @Id
    Integer id;

    int mark;
}

package com.example.officeProductSelector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    //Lob - large object Указывает, что постоянное свойство или поле должно сохраняться как большой объект для типа большого объекта, поддерживаемого базой данных.
    @Lob
    private String logo;
}

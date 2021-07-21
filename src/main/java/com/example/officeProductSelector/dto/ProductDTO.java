package com.example.officeProductSelector.dto;

import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String logo;
    @Getter
    @Setter
    private List<Mark> marks;
    @Getter
    @Setter
    private Double totalMark;

}

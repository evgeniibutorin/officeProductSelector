package com.example.officeProductSelector.dto;

import com.example.officeProductSelector.model.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

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

    public static final Comparator<ProductDTO> COMPARE_BY_TOTAL_MATK = new Comparator<ProductDTO>() {
        @Override
        public int compare(ProductDTO o1, ProductDTO o2) {
            return (int) (o1.getTotalMark() - o2.getTotalMark());
        }
    };

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMark=" + totalMark +
                '}';
    }
}


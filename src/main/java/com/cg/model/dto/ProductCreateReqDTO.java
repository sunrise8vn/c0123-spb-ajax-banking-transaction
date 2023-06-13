package com.cg.model.dto;

import com.cg.model.Category;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateReqDTO {

    private String title;
    private String price;
    private String description;
    private String unit;
    private Long categoryId;
    private MultipartFile avatar;

    @Override
    public String toString() {
        return "ProductCreateReqDTO{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", categoryId=" + categoryId +
                ", avatar=" + avatar +
                '}';
    }

    public Product toProduct(Category category) {
        return new Product()
                .setTitle(title)
                .setPrice(BigDecimal.valueOf(Long.parseLong(price)))
                .setDescription(description)
                .setUnit(unit)
                .setCategory(category)
                ;
    }
}

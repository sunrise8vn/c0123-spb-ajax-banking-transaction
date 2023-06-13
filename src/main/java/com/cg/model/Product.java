package com.cg.model;


import com.cg.model.dto.ProductCreateResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@Accessors(chain = true)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(precision = 10, scale = 0, nullable = false)
    private BigDecimal price;

    private Long quantity;

    @Lob
    private String description;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToOne
    @JoinColumn(name = "product_avatar_id", nullable = false)
    private ProductAvatar productAvatar;


    public ProductCreateResDTO toProductCreateResDTO() {
        return new ProductCreateResDTO()
                .setId(id)
                .setTitle(title)
                .setPrice(price)
                .setQuantity(quantity)
                .setUnit(unit)
                .setDescription(description)
                .setCategoryTitle(category.getTitle())
                .setAvatar(productAvatar.toProductAvatarCreateResDTO())
                ;
    }
}

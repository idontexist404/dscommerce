package com.highlander.dscommerce.dto;

import com.highlander.dscommerce.entities.Category;
import com.highlander.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Field size: 3-80 characters long")
    @NotBlank(message = "Required field")
    private String name;

    @Size(min = 10, message = "The description must be at least 10 characters long")
    @NotBlank(message = "Required field")
    private String description;

    @NotNull(message = "Required field")
    @Positive(message = "The price must be positive")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Must include at least one category")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}

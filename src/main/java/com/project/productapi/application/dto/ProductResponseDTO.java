package com.project.productapi.application.dto;

import java.time.LocalDateTime;

import com.project.productapi.core.domain.Product;

public class ProductResponseDTO {
	final private Long				id;
	final private String			name;
	final private Double			price;
	final private String			description;
	final private String			category;
	final private Integer			stock;
	final private Boolean			digitalProduct;
	final private LocalDateTime		creationDate;

	public ProductResponseDTO (Long id, String name, Double price, String description, String category,
		Integer stock, Boolean digitalProduct, LocalDateTime creationDate) {
		this.id = id;
		this.name = name;
		this. price = price;
		this.description = description;
		this.category = category;
		this.stock = stock;
		this.digitalProduct = digitalProduct;
		this.creationDate = creationDate;
		}

	public static ProductResponseDTO productToResponseDTO (Product prod) {

		return (new ProductResponseDTO(
				prod.getId(),
				prod.getName(),
				prod.getPrice(),
				prod.getDescription(),
				prod.getCategory(),
				prod.getStock(),
				prod.getDigitalProduct(),
				prod.getCreationDate()));
	}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Integer getStock() {
        return stock;
    }

    public Boolean getDigitalProduct() {
        return digitalProduct;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}

package com.project.productapi.application.dto;

import com.project.productapi.application.command.UpdateProductCommand;

public class UpdateProductRequestDTO {

	final private String			name;
	final private Double			price;
	final private String			description;
	final private String			category;
	final private Integer			stock;
	final private Boolean			digitalProduct;

	public UpdateProductRequestDTO(String name, Double price, String description, String category, Integer stock, Boolean digitalProduct) {
			this.name = name;
			this.price = price;
			this.description = description;
			this.category = category;
			this.stock = stock;
			this.digitalProduct = digitalProduct;
		}

	public UpdateProductCommand dtoToCommand(Long id)	{
		return new UpdateProductCommand(
			id,
			this.name,
            this.price,
            this.description,
            this.category,
            this.stock,
            this.digitalProduct);
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

	
}

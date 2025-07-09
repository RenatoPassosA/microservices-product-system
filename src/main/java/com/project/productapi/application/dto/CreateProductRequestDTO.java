package com.project.productapi.application.dto;

import java.time.LocalDateTime;

import com.project.productapi.application.command.CreateProductCommand;

public class CreateProductRequestDTO {

	//@NotBlank(message = "O nome é obrigatório")
	final private String			name;
	//@Positive(message = "O preço deve ser positivo")
	final private Double			price;
	//@Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
	final private String			description;
	//@NotBlank(message = "A categoria é obrigatória")
	final private String			category;
	//@Positive(message = "O estoque para cadastro deve ser positivo")
	final private Integer			stock;
	//@NotNull(message = "É obrigatório informar se o produto é digital")
	final private Boolean			digitalProduct;

	public CreateProductRequestDTO(String name, Double price, String description, String category, Integer stock, Boolean digitalProduct) {
			this.name = name;
			this.price = price;
			this.description = description;
			this.category = category;
			this.stock = stock;
			this.digitalProduct = digitalProduct;
		}

	public CreateProductCommand toCommand()	{
		return new CreateProductCommand(
			this.name,
            this.price,
            this.description,
            this.category,
            this.stock,
            this.digitalProduct,
			LocalDateTime.now());
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

package com.project.productapi.application.command;

public class UpdateProductCommand {
		final private Long				id;
        final private String			name;
        final private Double			price;
        final private String			description;
        final private String			category;
        final private Integer			stock;
        final private Boolean			digitalProduct;

		public UpdateProductCommand (Long	id, String name, Double price, String description, String category,
		Integer stock, Boolean digitalProduct) {
			this.id = id;
			this.name = name;
			this. price = price;
			this.description = description;
			this.category = category;
			this.stock = stock;
			this.digitalProduct = digitalProduct;
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
}

package main.java.com.project.productapi.core.domain;

import java.time.LocalDateTime;

public class Product {
		private Long			id;
        private String			name;
        private Double			price;
        private String			description;
        private String			category;
        private Integer			stock;
        private Boolean			digitalProduct;
        private LocalDateTime	creationDate;

		public Product() {
		}

		public Product (Long id, String name, Double price, String description, String category,
						Integer stock, Boolean digitalProduct, LocalDateTime creationDate){
			basicValidations(name, price, description, category, stock, digitalProduct, creationDate);
			this.id = null; //inicia null para ser preenchido pelo adapter (banco de dados seta automaticamente)
			this.name = name;
			this. price = price;
			this.description = description;
			this.category = category;
			this.stock = stock;
			this.digitalProduct = digitalProduct;
			this.creationDate = creationDate; //usecase vai definir esse valor
		}

		private void	basicValidations(String name, Double price, String description, String category,
								Integer stock, Boolean digitalProduct, LocalDateTime creationDate){
			if (name == null || name.isBlank())
				throw new IllegalArgumentException("Nome Inválido");
			if (price == null || price <= 0)
				throw new IllegalArgumentException("Preço inválido");
			if (description == null || description.isBlank())
				throw new IllegalArgumentException("Descrição Inválida");
			if (category == null || category.isBlank())
				throw new IllegalArgumentException("Categoria Inválida");
			if (stock == null || stock <= 0)
				throw new IllegalArgumentException("Estoque inválido");
			if (digitalProduct == null)
				throw new IllegalArgumentException("Produto fisico ou digital inválido");
			if (creationDate == null)
				throw new IllegalArgumentException("Data de criação inválida");
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

		public void setId(Long id) {
			if (this.id != null)
				throw new IllegalStateException("ID já definido");
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public void setDigitalProduct(Boolean digitalProduct) {
			this.digitalProduct = digitalProduct;
		}

		public void setCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
		}
}


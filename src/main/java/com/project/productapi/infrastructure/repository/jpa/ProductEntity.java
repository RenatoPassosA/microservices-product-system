package com.project.productapi.infrastructure.repository.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long			id;
    @Column(nullable = false)
    private String			name;
    @Column(nullable = false)
    private Double			price;
    @Column(length = 255)
    private String			description;
    @Column(nullable = false)
    private String			category;
    @Column(nullable = false)
    private Integer			stock;
    @Column(nullable = false)
    private Boolean			digitalProduct;
    @Column(nullable = false)
    private LocalDateTime	creationDate;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, Double price, String description, String category, Integer stock, Boolean digitalProduct, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.digitalProduct = digitalProduct;
        this.creationDate = creationDate;
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

/* Essa classe é a representação da sua entidade de banco de dados — ou seja, é como o JPA enxerga a tabela no DB.
Ela mapeia uma tabela real do banco para um objeto Java, e cada atributo da classe mapeia uma coluna da tabela. */
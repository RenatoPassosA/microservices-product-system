package com.project.productapi.infrastructure.repository.jpa;

import com.project.productapi.core.domain.Product;

public class ProductEntityMapper {
    
    public static ProductEntity toEntity(Product product) {
      
        return (new ProductEntity(product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDescription(),
            product.getCategory(),
            product.getStock(),
            product.getDigitalProduct(),
            product.getCreationDate()));
    }

    public static Product toDomain(ProductEntity product) {
        
        return (new Product(product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDescription(),
            product.getCategory(),
            product.getStock(),
            product.getDigitalProduct(),
            product.getCreationDate()));
    }
}

/*
 * Essa é uma classe sem estado: ela não guarda dados internos que mudam.
 * Todos os métodos:
 * são static, ou seja, pertencem à classe e não precisam de instância;
 * recebem todos os dados que precisam como parâmetro;
 * não armazenam nada entre chamadas.
 * 
 * essa classe só converte objetos, nao precisa guardar nada
 */
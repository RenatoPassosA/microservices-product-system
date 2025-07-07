package main.java.com.project.productapi.core.usecases;

import java.util.Optional;

import main.java.com.project.productapi.core.domain.Product;

public interface FindProductByNameUseCase {
	Optional<Product> execute(String name);
	
}


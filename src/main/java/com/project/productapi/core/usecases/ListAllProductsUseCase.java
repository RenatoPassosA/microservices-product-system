package main.java.com.project.productapi.core.usecases;

import java.util.List;

import main.java.com.project.productapi.core.domain.Product;

public interface ListAllProductsUseCase {
		List<Product> execute();
}

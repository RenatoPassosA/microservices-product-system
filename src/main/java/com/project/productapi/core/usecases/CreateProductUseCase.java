package main.java.com.project.productapi.core.usecases;

import main.java.com.project.productapi.core.domain.Product;

public interface CreateProductUseCase {
	 Product execute(CreateProductCommand command);
}

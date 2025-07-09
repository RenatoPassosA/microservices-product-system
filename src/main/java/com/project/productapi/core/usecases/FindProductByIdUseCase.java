package com.project.productapi.core.usecases;

import java.util.Optional;

import com.project.productapi.core.domain.Product;

public interface FindProductByIdUseCase {
	Optional<Product> execute(Long id);		
}

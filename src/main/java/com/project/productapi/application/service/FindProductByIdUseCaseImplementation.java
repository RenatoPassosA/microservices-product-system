package com.project.productapi.application.service;

import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.FindProductByIdUseCase;

public class FindProductByIdUseCaseImplementation implements FindProductByIdUseCase {
	private final ProductRepository productRepository;
	
	public FindProductByIdUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(Long id) {
		
    	return productRepository.findById(id)
        .orElseThrow(() -> 
		new IllegalArgumentException("Produto não encontrado"));
	}
}

package com.project.productapi.application.service;

import org.springframework.stereotype.Service;

import com.project.productapi.application.exceptions.ProductNotFoundException;
import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.FindProductByIdUseCase;

@Service
public class FindProductByIdUseCaseImplementation implements FindProductByIdUseCase {
	private final ProductRepository productRepository;
	
	public FindProductByIdUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(Long id) {
		
    	return productRepository.findById(id)
        .orElseThrow(() -> 
		new ProductNotFoundException("Produto não encontrado"));
	}
}

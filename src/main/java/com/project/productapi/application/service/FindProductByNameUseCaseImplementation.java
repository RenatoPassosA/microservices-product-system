package com.project.productapi.application.service;

import org.springframework.stereotype.Service;

import com.project.productapi.application.exceptions.ProductNotFoundException;
import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.FindProductByNameUseCase;

@Service
public class FindProductByNameUseCaseImplementation implements FindProductByNameUseCase {
	private final ProductRepository productRepository;
	
	public FindProductByNameUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(String name)
	{
		return productRepository.findByName(name)
        .orElseThrow(() -> 
		new ProductNotFoundException("Produto não encontrado"));
	}
}

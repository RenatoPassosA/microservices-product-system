package com.project.productapi.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.ListAllProductsUseCase;

@Service
public class ListAllProductsUseCaseImplementation implements ListAllProductsUseCase {
	private final ProductRepository productRepository;
	
	public ListAllProductsUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> execute()
	{
		return(productRepository.findAll());
	}
}

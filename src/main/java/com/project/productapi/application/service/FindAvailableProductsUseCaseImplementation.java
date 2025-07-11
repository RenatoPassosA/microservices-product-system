package com.project.productapi.application.service;

import java.util.List;

import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.FindAvailableProductsUseCase;

public class FindAvailableProductsUseCaseImplementation implements FindAvailableProductsUseCase {
	
	private final ProductRepository productRepository;
	
	public FindAvailableProductsUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> execute()
	{
		List<Product> prodList = productRepository.findProductsWithStockGreaterThanZero();
		return(prodList);
	}
}

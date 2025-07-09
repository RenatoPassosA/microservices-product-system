package com.project.productapi.application.service;

import java.util.List;

import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.FindProductsByPriceRangeUseCase;

public class FindProductsByPriceRangeUseCaseImplementation implements FindProductsByPriceRangeUseCase {
	private final ProductRepository productRepository;
	
	public FindProductsByPriceRangeUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> execute(Double init, Double end)
	{
		return(productRepository.findByPriceRange(init, end));
	}
}

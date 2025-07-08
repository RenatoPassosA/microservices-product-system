package main.java.com.project.productapi.application.service;

import java.util.Optional;

import main.java.com.project.productapi.core.domain.Product;
import main.java.com.project.productapi.core.gateway.ProductRepository;
import main.java.com.project.productapi.core.usecases.FindProductByNameUseCase;

public class FindProductByNameUseCaseImplementation implements FindProductByNameUseCase {
	private final ProductRepository productRepository;
	
	public FindProductByNameUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Optional<Product> execute(String name)
	{
		return(productRepository.findByName(name));
	}
}

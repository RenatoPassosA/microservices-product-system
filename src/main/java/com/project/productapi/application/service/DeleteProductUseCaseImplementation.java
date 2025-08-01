package com.project.productapi.application.service;

import org.springframework.stereotype.Service;

import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.DeleteProductUseCase;

@Service
public class DeleteProductUseCaseImplementation implements DeleteProductUseCase{

	private final ProductRepository productRepository;
	
	public DeleteProductUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public void execute(Long id)
	{
		if (!this.productRepository.findById(id).isPresent())
			throw new IllegalArgumentException("Produto não encontrado");

		this.productRepository.deleteById(id);
	}
}

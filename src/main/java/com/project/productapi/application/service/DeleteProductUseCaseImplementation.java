package main.java.com.project.productapi.application.service;

import main.java.com.project.productapi.core.gateway.ProductRepository;
import main.java.com.project.productapi.core.usecases.DeleteProductUseCase;

public class DeleteProductUseCaseImplementation implements DeleteProductUseCase{

	private final ProductRepository productRepository;
	
	public DeleteProductUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public void execute(Long	id)
	{
		if (this.productRepository.findById(id).isPresent())
			throw new IllegalArgumentException("Produto não encontrado");

		this.productRepository.deleteById(id);
	}
}

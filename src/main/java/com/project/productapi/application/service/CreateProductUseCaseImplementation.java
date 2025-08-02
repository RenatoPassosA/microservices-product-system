package com.project.productapi.application.service;

import org.springframework.stereotype.Service;

import com.project.productapi.application.command.CreateProductCommand;
import com.project.productapi.application.exceptions.DuplicateProductNameException;
import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.CreateProductUseCase;

@Service
public class CreateProductUseCaseImplementation implements CreateProductUseCase{
	
	private final ProductRepository productRepository;
	
	public CreateProductUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(CreateProductCommand productCommand)
	{
		if (this.productRepository.findByName(productCommand.getName()).isPresent())
			throw new DuplicateProductNameException("Produto com esse nome já existe");

		Product prod = new Product(
			null,
			productCommand.getName(),
			productCommand.getPrice(),
			productCommand.getDescription(),
			productCommand.getCategory(),
			productCommand.getStock(),
			productCommand.getDigitalProduct(),
			productCommand.getCreationDate()
		);

		return(productRepository.save(prod)); //setar o repositório para que o save retorne a entidade com o id preenchido
	}
}

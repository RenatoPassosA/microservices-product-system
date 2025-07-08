package main.java.com.project.productapi.application.service;

import main.java.com.project.productapi.core.domain.Product;
import main.java.com.project.productapi.core.gateway.ProductRepository;
import main.java.com.project.productapi.core.usecases.CreateProductUseCase;

import main.java.com.project.productapi.application.command.CreateProductCommand;

public class CreateProductUseCaseImplementation implements CreateProductUseCase{
	
	private final ProductRepository productRepository;
	
	public CreateProductUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(CreateProductCommand productCommand)
	{
		if (this.productRepository.findByName(productCommand.getName()).isPresent())
			throw new IllegalArgumentException("Produto com esse nome já existe");

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

		return(productRepository.save(prod)); //setar o repositório para que o save retorno a entidade com o id preenchido
	}
}

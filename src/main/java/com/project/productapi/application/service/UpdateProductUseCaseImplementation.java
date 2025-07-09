package com.project.productapi.application.service;

import java.util.Optional;

import com.project.productapi.application.command.UpdateProductCommand;
import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;
import com.project.productapi.core.usecases.UpdateProductUseCase;

public class UpdateProductUseCaseImplementation implements UpdateProductUseCase{
	
	private final ProductRepository productRepository;
	
	public UpdateProductUseCaseImplementation(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Override
	public Product execute(UpdateProductCommand productCommand)
	{
		Optional<Product>	prod = this.productRepository.findById(productCommand.getId());
		if (prod.isEmpty())
			throw new IllegalArgumentException("Produto não encontrado");
		Product existingProd = prod.get();  //achou o produto pelo id que pretende att

		if (!productCommand.getName().equals(existingProd.getName())) //verificação se existe produto com o mesmo nome que se quer atualizar
			if (productRepository.findByName(productCommand.getName()).isPresent())
				throw new IllegalArgumentException("Produto com esse nome já existe");

		if (productCommand.getName() != null && !productCommand.getName().isBlank())
			existingProd.setName(productCommand.getName());
		if (productCommand.getPrice() != null && productCommand.getPrice() != 0)
			existingProd.setPrice(productCommand.getPrice());
		if (productCommand.getDescription() != null && !productCommand.getDescription().isBlank())
			existingProd.setDescription(productCommand.getDescription());
		if (productCommand.getCategory() != null && !productCommand.getCategory().isBlank())
			existingProd.setCategory(productCommand.getCategory());
		if (productCommand.getStock() != null && productCommand.getStock() != 0)
			existingProd.setStock(productCommand.getStock());
		if (productCommand.getDigitalProduct() != null)
			existingProd.setDigitalProduct(productCommand.getDigitalProduct());

		return(productRepository.save(existingProd));
	}
}
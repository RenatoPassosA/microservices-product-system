package main.java.com.project.productapi.application.service;

import java.util.Optional;

import main.java.com.project.productapi.application.result.CheckStockResult;
import main.java.com.project.productapi.core.domain.Product;
import main.java.com.project.productapi.core.gateway.ProductRepository;
import main.java.com.project.productapi.core.usecases.CheckProductStockUseCase;

public class CheckProductStockUseCaseImplementation implements CheckProductStockUseCase{
	
	private final ProductRepository productRepository;

	public CheckProductStockUseCaseImplementation(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public CheckStockResult execute(Long id) {

		Optional <Product> findProd = productRepository.findById(id);

		if (!findProd.isPresent())
			throw new IllegalArgumentException("Produto não encontrado");

		CheckStockResult prod = new CheckStockResult(findProd.get().getId(),
		findProd.get().getName(),
		findProd.get().getStock());

		return(prod);
	}
}


/* poderia substituir por esse codigo:
 * 
 * Product prod = productRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

return new CheckStockResult(prod.getId(), prod.getName(), prod.getStock());
 */
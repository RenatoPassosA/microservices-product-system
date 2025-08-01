package com.project.productapi.adapters.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productapi.application.command.CreateProductCommand;
import com.project.productapi.application.command.UpdateProductCommand;
import com.project.productapi.application.dto.CreateProductRequestDTO;
import com.project.productapi.application.dto.ProductResponseDTO;
import com.project.productapi.application.dto.UpdateProductRequestDTO;
import com.project.productapi.application.dto.UpdateProductResponseDTO;
import com.project.productapi.core.domain.Product;
import com.project.productapi.core.usecases.CheckProductStockUseCase;
import com.project.productapi.core.usecases.CreateProductUseCase;
import com.project.productapi.core.usecases.DeleteProductUseCase;
import com.project.productapi.core.usecases.FindAvailableProductsUseCase;
import com.project.productapi.core.usecases.FindProductByIdUseCase;
import com.project.productapi.core.usecases.FindProductByNameUseCase;
import com.project.productapi.core.usecases.FindProductsByPriceRangeUseCase;
import com.project.productapi.core.usecases.ListAllProductsUseCase;
import com.project.productapi.core.usecases.UpdateProductUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

import com.project.productapi.application.result.CheckStockResult;



@RestController
@RequestMapping("/products")
public class ProductController {

	private final CreateProductUseCase				createProductUseCase;
	private final DeleteProductUseCase				deleteProductUseCase;
	private final FindAvailableProductsUseCase		findAvailableProductsUseCase;
	private final FindProductByIdUseCase			findProductByIdUseCase;
	private final FindProductByNameUseCase			findProductByNameUseCase;
	private final FindProductsByPriceRangeUseCase	findProductsByPriceRangeUseCase;
	private final ListAllProductsUseCase			listAllProductsUseCase;
	private final UpdateProductUseCase				updateProductUseCase;
	private final CheckProductStockUseCase			checkProductStockUseCase;
	
	public ProductController(
		CreateProductUseCase createProductUseCase,
		DeleteProductUseCase deleteProductUseCase,
		FindAvailableProductsUseCase findAvailableProductsUseCase,
		FindProductByIdUseCase findProductByIdUseCase,
		FindProductByNameUseCase findProductByNameUseCase,
		FindProductsByPriceRangeUseCase findProductsByPriceRangeUseCase,
		ListAllProductsUseCase listAllProductsUseCase,
		UpdateProductUseCase updateProductUseCase,
		CheckProductStockUseCase checkProductStockUseCase) {
			this.createProductUseCase = createProductUseCase;
			this.deleteProductUseCase = deleteProductUseCase;
			this.findAvailableProductsUseCase = findAvailableProductsUseCase;
			this.findProductByIdUseCase = findProductByIdUseCase;
			this.findProductByNameUseCase = findProductByNameUseCase;
			this.findProductsByPriceRangeUseCase = findProductsByPriceRangeUseCase;
			this.listAllProductsUseCase = listAllProductsUseCase;
			this.updateProductUseCase = updateProductUseCase;
			this.checkProductStockUseCase = checkProductStockUseCase;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid CreateProductRequestDTO product) {

		CreateProductCommand prodCommand = product.dtoToCommand();
		Product prod = createProductUseCase.execute(prodCommand);
		
		return ResponseEntity
    		.status(HttpStatus.CREATED)
    		.body(ProductResponseDTO.productToResponseDTO(prod));
	}
	
	@PutMapping("products/id/{id}")
	public ResponseEntity<UpdateProductResponseDTO> updateProduct(@PathVariable  @Valid Long id, @RequestBody UpdateProductRequestDTO product) {
		
		UpdateProductCommand updateprodCommand = product.dtoToCommand(id);
		Product prod = updateProductUseCase.execute(updateprodCommand);

		return ResponseEntity
			.status(HttpStatus.OK)
			.body(new UpdateProductResponseDTO(
				id,
				prod.getName(),
				prod.getPrice(),
				prod.getDescription(),
				prod.getCategory(),
				prod.getStock(),
				prod.getDigitalProduct(),
				prod.getCreationDate()));
	}

	@DeleteMapping("products/id/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

		deleteProductUseCase.execute((id));
		return (ResponseEntity.noContent().build());
	}

	@GetMapping("products/available")
	public ResponseEntity<List<ProductResponseDTO>> findAvailable() {
		
		List<Product> products = findAvailableProductsUseCase.execute();
		List<ProductResponseDTO> responseDTO = new ArrayList<>();

		for (Product product: products) {
			responseDTO.add(ProductResponseDTO.productToResponseDTO(product));
		}
		return(ResponseEntity.status(HttpStatus.OK).body(responseDTO));
		
	}

	@GetMapping("products/id/{id}")
	public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
		
		Product prod = findProductByIdUseCase.execute(id);

		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ProductResponseDTO.productToResponseDTO(prod));
	}

	@GetMapping("products/name/{name}")
	public ResponseEntity<ProductResponseDTO> findByName(@PathVariable String name) {
		
		Product prod = findProductByNameUseCase.execute(name);

		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ProductResponseDTO.productToResponseDTO(prod));
	}
// findProductsByPriceRangeUseCase
	@GetMapping("products/price-range")
	public ResponseEntity<List<ProductResponseDTO>> findByRange (@RequestParam Double min, Double max) {

		List<Product> prods = findProductsByPriceRangeUseCase.execute(min, max);
		List<ProductResponseDTO> response = new ArrayList<>();

		for(Product product : prods) {
			response.add(ProductResponseDTO.productToResponseDTO(product));
		}
		return (ResponseEntity.status(HttpStatus.OK).body(response));
	}

	@GetMapping("products")
	public ResponseEntity<List<ProductResponseDTO>> listAll() {

		List<Product> prods = listAllProductsUseCase.execute();
		List<ProductResponseDTO> response = new ArrayList<>();

		for(Product product : prods) {
			
			response.add(ProductResponseDTO.productToResponseDTO(product));
		}
		return (ResponseEntity.status(HttpStatus.OK).body(response));
	}

	// checkProductStockUseCase
	@GetMapping("products/stock/{id}")
	public ResponseEntity<CheckStockResult> checkStock(@PathVariable Long id)
	{
		return (ResponseEntity
		.status(HttpStatus.OK)
		.body(checkProductStockUseCase.execute(id)));
	}
}

/*Sempre que um use case gerar um resultado relevante para o cliente (por exemplo, um produto criado ou uma busca retornando um produto), 
 você deve expô-lo através de um endpoint na sua API. 
 O JSON recebido na requisição HTTP é convertido para um DTO de forma automática pelo spring
 O back e o front devem estar alinhados para chegar as infos contendo os campos corretos
 
 A rota é como a url aparece no navegador. Eu que defino como ela será estruturada*/
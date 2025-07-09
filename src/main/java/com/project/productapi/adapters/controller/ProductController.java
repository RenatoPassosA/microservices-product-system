package com.project.productapi.adapters.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productapi.application.dto.CreateProductRequestDTO;
import com.project.productapi.application.dto.CreateProductResponseDTO;
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
	public  CreateProductResponseDTO createProduct(@RequestBody @Valid CreateProductRequestDTO product)
	{
		CreateProductResponseDTO response;
		Product         prod;

		
		return(response);
	}
           
}

/*Sempre que um use case gerar um resultado relevante para o cliente (por exemplo, um produto criado ou uma busca retornando um produto), 
 você deve expô-lo através de um endpoint na sua API. 
 O JSON recebido na requisição HTTP é convertido para um DTO de forma automática pelo spring
 Oback e o front devem estar alinhados para chegar as infos contendo os campos corretos*/
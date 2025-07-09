package com.project.productapi.core.gateway;

import java.util.List;
import java.util.Optional;

import com.project.productapi.core.domain.Product;

public interface ProductRepository {
	Product save(Product product); //create and update product
	Optional<Product> findByName(String name); //create product - validação de duplicidade
	Optional<Product> findById(Long id); //find, update, delete
	List<Product> findAll(); //list all
	void deleteById(Long id); //delete
	List<Product> findByPriceRange(Double min, Double max); //findrange
	List<Product> findProductsWithStockGreaterThanZero(); //find available
}


/*Aqui devem estar os métodos necessários para TODOS os usecases
 * Analisar cada usecase e verificar se precisar de metodos intermediarios ou os metodos que diretamente o cumprem
 */

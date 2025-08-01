package com.project.productapi.infrastructure.repository.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.productapi.core.domain.Product;
import com.project.productapi.core.gateway.ProductRepository;

@Repository
public class ProductRepositoryJPAImplementation implements ProductRepository{

    private JpaProductRepository JPArepo;
    
    public ProductRepositoryJPAImplementation (JpaProductRepository repo){
        this.JPArepo = repo;
    }

    @Override
    public Product save(Product product) {

        ProductEntity prodForDB = ProductEntityMapper.toEntity(product);
        ProductEntity savedEntity = JPArepo.save(prodForDB); //aqui o que eu tenho que salvar é a Entity, pois é o tipo de dado que o JPA entende e manipula.
        Product prodForReturn = ProductEntityMapper.toDomain(savedEntity); //aqui eu devo converter de volta o objeto salvo, pois o JPA pode modificar ou preencher automaticamente algum campo.
        return (prodForReturn);
    }

    @Override
    public Optional<Product> findByName(String name) {

        return (JPArepo.findByName(name).map(ProductEntityMapper::toDomain));

        /* Essa forma acima é otimizada pelo JPA
            da pra fazer assim:

            Optional<ProductEntity> optionalEntity = JPArepo.findByName(name);

            if (optionalEntity.isPresent()) {
                Product product = ProductEntityMapper.toDomain(optionalEntity.get());
                return Optional.of(product);
            } else {
                return Optional.empty();
            }
         * 
         */
    }

    @Override
    public Optional<Product> findById(Long id) {

        return (JPArepo.findById(id).map(ProductEntityMapper::toDomain));
    }

    @Override
    public List<Product> findAll() {
        
        List<Product> prodList = new ArrayList<>();
        List<ProductEntity> allProds = JPArepo.findAll();

        for (ProductEntity product: allProds) {
			prodList.add(ProductEntityMapper.toDomain(product));
		}
        return(prodList);
    }

    @Override
    public void deleteById(Long id) {
        JPArepo.deleteById(id);
    }

    @Override
    public List<Product> findByPriceRange(Double min, Double max) {
        
        return (JPArepo.findByPriceBetween(min, max)
                        .stream()
                        .map(ProductEntityMapper::toDomain)
                        .toList());

        //essa é uma opção de escrita que equivale a mesma coisa que foi feita no findAll
    }

    @Override
    public List<Product> findProductsWithStockGreaterThanZero() {
        
        return (JPArepo.findByStockGreaterThan(0)
                        .stream()
                        .map(ProductEntityMapper::toDomain)
                        .toList());
    }
}

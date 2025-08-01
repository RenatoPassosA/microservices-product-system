package com.project.productapi.infrastructure.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String name); //create product - validação de duplicidade
	List<ProductEntity> findByPriceBetween(Double min, Double max); //findrange
	List<ProductEntity> findByStockGreaterThan(Integer stock); //find available
}

/*
    Aqui devo estender a JpaRepository

    JpaRepository<T, ID> é uma interface genérica do Spring Data JPA que te fornece métodos prontos para acessar o banco de dados (como findAll(), findById(), save() etc.).
    Esses dois parâmetros (ProductEntity e Long) servem para informar ao Spring:

    <T> (ProductEntity)	Qual entidade (tabela) ele vai gerenciar
    <ID> (Long)	Qual o tipo do campo @Id da entidade (chave primária)

    Aqui só devem entrar os métodos do product repository, porem somente os que eu criei sem ser os default


    O JPA tem uma funcionalidade de criar querys a partir de palavras chaves e o nome do atributos se utilizados no nome do metodo
    Spring Data JPA gera a query com base em:
    1. Nome do método
    2. Nome exato do atributo da entidade
    3. Palavras-chave reconhecidas (como Between, GreaterThan, Like, etc.)
 */
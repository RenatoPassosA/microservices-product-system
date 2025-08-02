package com.project.productapi.config;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers //ativa o **gerenciamento automático de containers Docker** durante os testes.
public abstract class PostgresTestContainerConfig { //A classe é `abstract` para que você **não rode testes diretamente nela** — ela será estendida por outras classes de teste

    @Container //
    protected static final PostgreSQLContainer<?> POSTGRES_CONTAINER = 
        new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
        /* aqui estou marca esse campo como um container Docker que será iniciado pelo Testcontainers
         * será criado um container PostgreSQL (versão 15) com: Nome do banco: testdb, Usuário: test, Senha: test
         * Ele será iniciado automaticamente antes dos testes e finalizado depois.
         */

    @DynamicPropertySource // permite que você adicione ou sobrescreva dinamicamente propriedades do Spring — como se estivesse editando o application.yml, mas em tempo de execução
    public static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
    }
    
}

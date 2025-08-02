package com.project.productapi.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.productapi.application.dto.CreateProductRequestDTO;
import com.project.productapi.config.PostgresTestContainerConfig;
import com.project.productapi.repository.test.TestProductRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;

@SpringBootTest
@EnableJpaRepositories(basePackages = {
    "com.project.productapi.infrastructure.repository.jpa",
    "com.project.productapi.repository.test"
})
@EntityScan(basePackages = {
    "com.project.productapi.infrastructure.repository.jpa"
})
@AutoConfigureMockMvc
@ActiveProfiles("test") //usa o profile test(application-test.yml)
public class GetProductIntegrationTest extends PostgresTestContainerConfig {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TestProductRepository testProductRepository;

    @BeforeEach
    public void cleanDatabase() {
        testProductRepository.deleteAll();
    }

    
}

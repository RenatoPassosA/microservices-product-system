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
public class IntegrationTests extends PostgresTestContainerConfig {

    @Autowired
    private MockMvc mockMvc; //essa variável será usada nos métodos de teste para simular requisições HTTP
    @Autowired
    private ObjectMapper objectMapper; //componente usado para converter objetos Java em JSON e vice-versa
    @Autowired
    private TestProductRepository testProductRepository;

    @BeforeEach
    public void cleanDatabase() {
        testProductRepository.deleteAll();
    }


    // ---------------- POST ----------------
    @Test
    public void createProductSucessfully() throws Exception {

        CreateProductRequestDTO request = new CreateProductRequestDTO("Notebook", 8.000, "Gamer", "Tecnologia", 100, false);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Notebook"));
    }

    @Test
    public void createProductWithoutNameFail() throws Exception {
        String json = """
                    {
                    "price": 8000,
                    "description": "Gamer",
                    "category": "Tecnologia",
                    "digitalProduct": false
                    }
                    """;

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createProductSameNameFail() throws Exception {
        CreateProductRequestDTO request = new CreateProductRequestDTO( "Notebook", 8000.00, "Gamer", "Tecnologia", 100, false);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isConflict());
    }

    @Test
    public void createProductWithNegativePriceFail() throws Exception {
        CreateProductRequestDTO request = new CreateProductRequestDTO( "Notebook", -100.00, "Gamer", "Tecnologia", 100, false);
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    // ---------------- GET ----------------
    @Test
    public void getProductByIdSuccess() throws Exception {

        CreateProductRequestDTO request = new CreateProductRequestDTO("Notebook", 8.000, "Gamer", "Tecnologia", 100, false);
        String json = objectMapper.writeValueAsString(request);

        MvcResult result = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Notebook"))
                .andReturn(); //aqui eu retorno um objeto que representa toda a resposta da requisição HTTP simulada feita com o MockMvc
        
        String responseBody = result.getResponse().getContentAsString();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------Response body: " + responseBody);
        JsonNode responseJson = objectMapper.readTree(responseBody);
        Long productId = responseJson.get("id").asLong(); //aqui eu faço a extração do id gerado pelo metodo acima

        mockMvc.perform(get("/products/{id}", productId)) //aqui eu faço o get com o id que retornou
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Notebook"));
    }
    
}



/*
    MockMvc é a ferramenta que você usará dentro dos seus métodos @Test para:
    Enviar requisições GET, POST, etc.
    Verificar o status da resposta
    Testar o comportamento da API como se fosse um cliente 


    import static - Torna um método ou campo estático acessível diretamente, sem precisar escrever o nome da classe toda vez.
*/

package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ProductApplicationTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductApplication productApplication;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks antes de cada teste
    }

    @Test
    public void deveSalvarImagemCorretamente() {
        // Arrange
        Product product = new Product(1, "Produto que tem a imagem", 59.99f, "imagem.jpg");

        // Act
        productApplication.append(product);

        // Assert
        verify(productService, times(1)).save(product);
    }

    @Test
    public void deveRemoverImagemCorretamente() {
        // Arrange
        int productId = 1;

        // Act
        productApplication.remove(productId);

        // Assert
        verify(productService, times(1)).remove(productId);
    }

    @Test
    public void deveAtualizarImagemCorretamente() {
        // Arrange
        int productId = 1;
        Product updatedProduct = new Product(productId, "Produto atualizado", 79.99f, "imagem_atualizada.jpg");

        // Act
        productApplication.update(productId, updatedProduct);

        // Assert conta quantidade de vezes que é chamado
        verify(productService, times(1)).update(updatedProduct);
    }
}


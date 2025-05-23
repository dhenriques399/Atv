package com.example.services;

import com.example.applications.ProductApplication;
import com.example.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class ProductApplicationTest {
        Product product;

        @InjectMocks // Foco do teste, nesse caso a classe ProductApplication.
        ProductApplication productApplication;

        @Mock // eu to focado na classe ProductApplocation são as dependencias que eu quero "mocar"
        ProductService productService;

        @BeforeEach
        public void setUp() {
            product  = new Product(1, "x-bacon", 100, "x-bacon.jpg");
        }

        @Test
        public void testarSalvarImgCorretamente() {
            productService.save(product);
            Mockito.verify(productService).save(product);
        }
        @Test
        public void testarRemoverImgCorretamente() {
            productService.remove(product.getId());
            Mockito.verify(productService).remove(product.getId());
        }
        @Test
        public void testarAtualizarImgCorretamente() {
            productService.update(product);
            Mockito.verify(productService).update(product);
        }
    }

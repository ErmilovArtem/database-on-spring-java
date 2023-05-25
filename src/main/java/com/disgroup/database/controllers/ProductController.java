package com.disgroup.database.controllers;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ArticleRepository;
import com.disgroup.database.repository.ProductRepository;
import com.disgroup.database.service.ProductServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Эндпоинты над product")
@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    private final ProductServiceImp productService;

    public ProductController(ProductRepository productRepository, ArticleRepository articleRepository) {
        this.productService = new ProductServiceImp(productRepository, articleRepository);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product _product) {
        Product product = productService.updateProduct(_product);
        if (product != null) {
            return ResponseEntity.ok(product); // Возвращаем HTTP 200 OK и найденную сущность
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP 404 Not Found, если сущность не найдена
        }
    }

    @DeleteMapping("/DelProductById/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable long id) {
        if (productService.deleteProductById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Конкретный продукт по ID")
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product); // Возвращаем HTTP 200 OK и найденную сущность
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP 404 Not Found, если сущность не найдена
        }
    }

    @Operation(summary = "Получение всех статей что описывают продукт(ID ASC)")
    @GetMapping("/GiveProductByArticleIdAsc/{id}")
    public List<Article> getArticleByProductIdAsc(@PathVariable long id) {
        return productService.getArticleByProductIdAsc(id);
    }

    @Operation(summary = "Получение всех статей что описывают продукт(ID DESC)")
    @GetMapping("/GiveProductByIdDesc/{id}")
    public List<Article> getArticleByProductIdDesc(@PathVariable long id) {
        return productService.getArticleByProductIdDesc(id);
    }

    @Operation(summary = "Получение всех статей по списку ID продуктов")
    @GetMapping("/GiveProductByListID/{id}")
    public List<Article> getArticleByProductListId(@PathVariable ArrayList<Long> ListId) {
        return productService.getArticleByProductListId(ListId);
    }

    @GetMapping("getByOrderByIdAsc")
    public List<Product> getByOrderByIdAsc() {
        return productService.getByOrderByIdAsc();
    }

    @GetMapping("getByOrderByIdDesc")
    public List<Product> getByOrderByIdDesc() {
        return productService.getByOrderByIdDesc();
    }

    @GetMapping("getByOrderByNameAsc")
    public List<Product> getByOrderByNameAsc() {
        return productService.getByOrderByNameAsc();
    }

    @GetMapping("getByOrderByNameDesc")
    public List<Product> getByOrderByNameDesc() {
        return productService.getByOrderByNameDesc();
    }

    @GetMapping("getByOrderByImplementationCostAsc")
    public List<Product> getByOrderByImplementationCostAsc() {
        return productService.getByOrderByImplementationCostAsc();
    }

    @GetMapping("getByOrderByImplementationCostDesc")
    public List<Product> getByOrderByImplementationCostDesc() {
        return productService.getByOrderByImplementationCostDesc();
    }

    @GetMapping("getByOrderByDescriptionAsc")
    public List<Product> getByOrderByDescriptionAsc() {
        return productService.getByOrderByDescriptionAsc();
    }

    @GetMapping("getByOrderByDescriptionDesc")
    public List<Product> getByOrderByDescriptionDesc() {
        return productService.getByOrderByDescriptionDesc();
    }

    @Operation(summary = "Нахождение продукта по его имени")
    @GetMapping("findByTitle/{keyword}")
    public List<Product> getByNameContainingIgnoreCase(@PathVariable String keyword) {
        return productService.getByNameContainingIgnoreCase(keyword);
    }
}

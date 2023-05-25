package com.disgroup.database.controllers;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ArticleRepository;
import com.disgroup.database.repository.ProductRepository;
import com.disgroup.database.service.ArticleServiceImp;
import com.disgroup.database.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Эндпоинты над article")
@RestController
@RequestMapping(path = "api/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleRepository articleRepository, ProductRepository productRepository) {
        this.articleService = new ArticleServiceImp(articleRepository, productRepository);
    }

    @PostMapping()
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article _article) {
        Article article = articleService.updateArticle(_article);
        if (article != null) {
            return ResponseEntity.ok(article); // Возвращаем HTTP 200 OK и найденную сущность
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP 404 Not Found, если сущность не найдена
        }
    }

    @DeleteMapping("/deleteArticleById/{id}")
    public ResponseEntity<Void> deleteArticleById(long id) {
        if (articleService.deleteArticleById(id)) {
            return ResponseEntity.noContent().build(); // Возвращаем HTTP 200 OK и найденную сущность
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP 404 Not Found, если сущность не найдена
        }
    }

    @Operation(summary = "Продукт, который описан в статье")
    @GetMapping("/ProductById/{id}")
    public ResponseEntity<Product> getListProductById(@PathVariable long id) {
        Product product = articleService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product); // Возвращаем HTTP 200 OK и найденную сущность
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP 404 Not Found, если сущность не найдена
        }
    }

    @Operation(summary = "Продукты, которые описаны в статьях")
    @GetMapping("/ProductByListId/{id}")
    public List<Product> giveProductById(@PathVariable List<Long> id) {
        return articleService.getListProductById(id);
    }

    @Operation(summary = "Статья по её ID")
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Все статьи что описывают продукт")
    @GetMapping("/ArticlesProductById/{id}")
    public List<Article> getArticlesByProductId(@PathVariable long id) {
        return articleService.getArticlesByProductIdAsc(id);
    }

    @GetMapping("/getByOrderByIdAsc")
    public List<Article> getByOrderByIdAsc() {
        return articleService.getByOrderByIdAsc();
    }

    @GetMapping("/getByOrderByIdDesc")
    public List<Article> getByOrderByIdDesc() {
        return articleService.getByOrderByIdDesc();
    }

    @GetMapping("/getByOrderByTitleAsc")
    public List<Article> getByOrderByTitleAsc() {
        return articleService.getByOrderByTitleAsc();
    }

    @GetMapping("/getByOrderByContentAsc")
    public List<Article> getByOrderByContentAsc() {
        return articleService.getByOrderByContentAsc();
    }

    @GetMapping("/getByOrderByContentDesc")
    public List<Article> getByOrderByContentDesc() {
        return articleService.getByOrderByContentDesc();
    }

    @GetMapping("/getByOrderByCreationDateAsc")
    public List<Article> getByOrderByCreationDateAsc() {
        return articleService.getByOrderByCreationDateAsc();
    }

    @GetMapping("/getByOrderByCreationDateDesc")
    public List<Article> getByOrderByCreationDateDesc() {
        return articleService.getByOrderByCreationDateDesc();
    }

    @Operation(summary = "Найти статью по заголовку")
    @GetMapping("findByTitle/{keyword}")
    public List<Article> getByTitleContainingIgnoreCase(@PathVariable String keyword) {
        return articleService.getByTitleContainingIgnoreCase(keyword);
    }
}

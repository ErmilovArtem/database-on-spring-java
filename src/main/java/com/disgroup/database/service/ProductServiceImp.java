package com.disgroup.database.service;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ArticleRepository;
import com.disgroup.database.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ArticleRepository articleRepository;

    public ProductServiceImp(ProductRepository productRepository, ArticleRepository articleRepository) {
        this.productRepository = productRepository;
        this.articleRepository = articleRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        if (productRepository.findById(id).isPresent())
            return productRepository.findById(id).get();
        return null;
    }

    public Product updateProduct(Product updatedProduct) {
        Optional<Product> ExistingArticle = productRepository.findById(updatedProduct.getId());
        if (ExistingArticle.isPresent()) {
            Product existingProduct = ExistingArticle.get();
            existingProduct.setImplementationCost(updatedProduct.getImplementationCost());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public boolean deleteProductById(long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    public List<Article> getArticleByProductIdAsc(long productId) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articleRepository.findByOrderByProductIdAsc()) {
            if (article.getProductId() == productId)
                articles.add(article);
        }
        return articles;
    }

    public List<Article> getArticleByProductIdDesc(long productId) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articleRepository.findByOrderByProductIdDesc()) {
            if (article.getProductId() == productId)
                articles.add(article);
        }
        return articles;
    }

    public List<Article> getArticleByProductListId(List<Long> ListId) {
        List<Article> articles = new ArrayList<>();
        for (long productId : ListId)
            for (Article article : articleRepository.findByOrderByProductIdDesc()) {
                if (Objects.equals(article.getProductId(), productId))
                    articles.add(article);
            }
        return articles;
    }

    public List<Product> getByOrderByIdAsc() {
        return productRepository.findByOrderByIdAsc();
    }

    public List<Product> getByOrderByIdDesc() {
        return productRepository.findByOrderByIdDesc();
    }

    public List<Product> getByOrderByNameAsc() {
        return productRepository.findByOrderByNameAsc();
    }

    public List<Product> getByOrderByNameDesc() {
        return productRepository.findByOrderByNameDesc();
    }

    public List<Product> getByOrderByImplementationCostAsc() {
        return productRepository.findByOrderByImplementationCostAsc();
    }

    public List<Product> getByOrderByImplementationCostDesc() {
        return productRepository.findByOrderByImplementationCostDesc();
    }

    public List<Product> getByOrderByDescriptionAsc() {
        return productRepository.findByOrderByDescriptionAsc();
    }

    public List<Product> getByOrderByDescriptionDesc() {
        return productRepository.findByOrderByDescriptionDesc();
    }

    public List<Product> getByNameContainingIgnoreCase(String keyword) {
        if (!productRepository.findByNameContainingIgnoreCase(keyword).isEmpty())
            return productRepository.findByNameContainingIgnoreCase(keyword);
        else
            return null;
    }
}

package com.disgroup.database.service;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    ProductRepository productRepository = null;
    ArticleServiceImp articleService = null;

    public Product createProduct(Product product);

    public Product getProductById(long id);

    public Product updateProduct(Product product);

    public boolean deleteProductById(long id);

    public List<Article> getArticleByProductIdAsc(long id);

    public List<Article> getArticleByProductIdDesc(long id);

    public List<Article> getArticleByProductListId(List<Long> ListId);

    public List<Product> getByOrderByIdAsc();

    public List<Product> getByOrderByIdDesc();

    public List<Product> getByOrderByNameAsc();

    public List<Product> getByOrderByNameDesc();

    public List<Product> getByOrderByImplementationCostAsc();

    public List<Product> getByOrderByImplementationCostDesc();

    public List<Product> getByOrderByDescriptionAsc();

    public List<Product> getByOrderByDescriptionDesc();

    public List<Product> getByNameContainingIgnoreCase(String keyword);
}

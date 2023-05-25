package com.disgroup.database.service;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ArticleRepository;

import java.util.List;

public interface ArticleService {
    ArticleRepository articleRepository = null;
    ProductServiceImp PRODUCT_SERVICE_IMP = null;

    public Product getProductById(long productId);

    public List<Product> getListProductById(List<Long> productId);

    public Article createArticle(Article article);

    public Article getArticleById(long id);

    public List<Article> getArticlesByProductIdAsc(long productId);

    public List<Article> getArticlesByProductIdDesc(long productId);

    public Article updateArticle(Article updatedArticle);

    public boolean deleteArticleById(long id);

    public List<Article> getByOrderByIdAsc();

    public List<Article> getByOrderByIdDesc();

    public List<Article> getByOrderByTitleAsc();

    public List<Article> getByOrderByContentAsc();

    public List<Article> getByOrderByContentDesc();

    public List<Article> getByOrderByCreationDateAsc();

    public List<Article> getByOrderByCreationDateDesc();

    public List<Article> getByTitleContainingIgnoreCase(String keyword);
}

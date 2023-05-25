package com.disgroup.database.service;

import com.disgroup.database.entity.Article;
import com.disgroup.database.entity.Product;
import com.disgroup.database.repository.ArticleRepository;
import com.disgroup.database.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ProductRepository productRepository;

    public ArticleServiceImp(ArticleRepository articleRepository, ProductRepository productRepository) {
        this.articleRepository = articleRepository;
        this.productRepository = productRepository;
    }

    //по заданию
    public Product getProductById(long id) {
        if (articleRepository.findById(id).isPresent())
            if (productRepository.findById(articleRepository.findById(id).get().getProductId()).isPresent())
                return productRepository.findById(articleRepository.findById(id).get().getProductId()).get();
        return null;
    }

    public List<Product> getListProductById(List<Long> idList) {
        List<Product> products = new ArrayList<>();
        for (long id : idList) {
            if (articleRepository.findById(id).isPresent())
                if (productRepository.findById(articleRepository.findById(id).get().getProductId()).isPresent())
                    products.add(productRepository.findById(articleRepository.findById(id).get().getProductId()).get());
        }
        return products;
    }

    public Article createArticle(Article article) {
        if (productRepository.findById(article.getProductId()).isPresent())
            return articleRepository.save(article);
        return null;
    }

    public Article getArticleById(long id) {
        if (articleRepository.findById(id).isPresent())
            return articleRepository.findById(id).get();
        return null;
    }

    public List<Article> getArticlesByProductIdAsc(long productId) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articleRepository.findByOrderByProductIdAsc()) {
            if (article.getProductId() == productId)
                articles.add(article);
        }
        return articles;
    }

    public List<Article> getArticlesByProductIdDesc(long productId) {
        List<Article> articles = new ArrayList<>();
        for (Article article : articleRepository.findByOrderByProductIdDesc()) {
            if (article.getProductId() == productId)
                articles.add(article);
        }
        return articles;
    }

    public Article updateArticle(Article updatedArticle) {
        if (!productRepository.existsById(updatedArticle.getProductId())) {
            return null;
        }
        Optional<Article> ExistingArticle = articleRepository.findById(updatedArticle.getId());
        if (ExistingArticle.isPresent()) {
            Article existingArticle = ExistingArticle.get();
            existingArticle.setTitle(updatedArticle.getTitle());
            existingArticle.setContent(updatedArticle.getContent());
            existingArticle.setCreationDate(updatedArticle.getCreationDate());
            return articleRepository.save(existingArticle);
        } else {
            return null;
        }
    }

    public boolean deleteArticleById(long id) {
        if (articleRepository.findById(id).isPresent()) {
            articleRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    public List<Article> getByOrderByIdAsc() {
        return articleRepository.findByOrderByIdAsc();
    }

    public List<Article> getByOrderByIdDesc() {
        return articleRepository.findByOrderByIdDesc();
    }

    public List<Article> getByOrderByTitleAsc() {
        return articleRepository.findByOrderByTitleAsc();
    }

    public List<Article> getByOrderByContentAsc() {
        return articleRepository.findByOrderByContentAsc();
    }

    public List<Article> getByOrderByContentDesc() {
        return articleRepository.findByOrderByContentDesc();
    }

    public List<Article> getByOrderByCreationDateAsc() {
        return articleRepository.findByOrderByCreationDateAsc();
    }

    public List<Article> getByOrderByCreationDateDesc() {
        return articleRepository.findByOrderByCreationDateDesc();
    }

    public List<Article> getByTitleContainingIgnoreCase(String keyword) {
        if (!articleRepository.findByTitleContainingIgnoreCase(keyword).isEmpty())
            return articleRepository.findByTitleContainingIgnoreCase(keyword);
        else
            return null;
    }
}

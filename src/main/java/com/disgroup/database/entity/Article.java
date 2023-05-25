package com.disgroup.database.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "product_Id")
    private Long productId;
    private String title;
    private String content;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date creationDate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Article))
            return false;
        Article article = (Article) o;
        return Objects.equals(this.id, article.id) && Objects.equals(this.productId, article.productId)
                && Objects.equals(this.title, article.title) && Objects.equals(this.content, article.content)
                && Objects.equals(this.creationDate, article.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.productId, this.title, this.content, this.creationDate);
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + this.id + ", productId='" + this.productId + '\''
                + ", title='" + this.title + '\'' + ", content='" + this.content + '\''
                + ", creationDate='" + this.creationDate + '\'' + '}';
    }
}

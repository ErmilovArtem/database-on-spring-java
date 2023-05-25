package com.disgroup.database.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @Column(name = "implementation_cost")
    private double implementationCost;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImplementationCost() {
        return implementationCost;
    }

    public void setImplementationCost(double implementationCost) {
        this.implementationCost = implementationCost;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id)
                && Objects.equals(this.name, product.name)
                && Objects.equals(this.description, product.description)
                && Objects.equals(this.implementationCost, product.implementationCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.implementationCost);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\''
                + ", description='" + this.description + '\'' + ", implementationCost='" + this.implementationCost + '\''
                + '}';
    }
}

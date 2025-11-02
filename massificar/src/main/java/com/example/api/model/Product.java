package com.example.api.model;

import jakarta.persistence.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Double price;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}
    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price=price;}
}

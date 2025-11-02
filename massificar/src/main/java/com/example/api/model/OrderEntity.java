package com.example.api.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "orders_table")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private java.util.List<Long> productIds;
    private Double total;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public java.util.List<Long> getProductIds(){return productIds;}
    public void setProductIds(java.util.List<Long> productIds){this.productIds=productIds;}
    public Double getTotal(){return total;}
    public void setTotal(Double total){this.total=total;}
}

package com.ecommerce.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Date orderDate;
    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    private Set<OrderItem> orderItems;

    private String status;

    public Order(Long id, User user, Date orderDate) {
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
    }
    public Order() {
    }
}

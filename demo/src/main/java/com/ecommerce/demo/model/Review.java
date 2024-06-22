package com.ecommerce.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int rating;

    private String comment;

    private LocalDateTime reviewDate;


    public Review() {
    }

    public Review(Long id, User user, Product product, int rating, String comment, LocalDateTime reviewDate) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }
}

package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Order;
import com.ecommerce.demo.model.OrderItem;
import com.ecommerce.demo.model.Review;
import com.ecommerce.demo.service.OrderItemService;
import com.ecommerce.demo.service.OrderService;
import com.ecommerce.demo.service.ProductService;
import com.ecommerce.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserAccessController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrderItems")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/getOrderItemById/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }


    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/createReview")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/getReviewById/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/getAllReviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
















}

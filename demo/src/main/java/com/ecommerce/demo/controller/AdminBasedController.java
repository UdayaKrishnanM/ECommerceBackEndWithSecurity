package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Order;
import com.ecommerce.demo.model.OrderItem;
import com.ecommerce.demo.model.Product;
import com.ecommerce.demo.model.Review;
import com.ecommerce.demo.service.OrderItemService;
import com.ecommerce.demo.service.OrderService;
import com.ecommerce.demo.service.ProductService;
import com.ecommerce.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminBasedController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @PostMapping("/createProduct")
    public String createProductPost(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @PostMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/createOrderItem")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @GetMapping("/deleteOrderItemsByItem/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }


    @GetMapping("/updateOrderStatus/{id}")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @GetMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }


    @GetMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
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

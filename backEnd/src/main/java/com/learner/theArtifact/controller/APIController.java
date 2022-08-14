package com.learner.theArtifact.controller;

import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {

    @Autowired
    private ProductService service;


    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.of(Optional.of("the api is up good..👍"));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        Product addedProduct = service.add(product);

        return ResponseEntity.of(Optional.of("product added successfully!\nHere's the unique product Id -> " + addedProduct.get_id()));
    }

    @CachePut(value = "products")
    @GetMapping("/list")
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.of(Optional.of(service.list()));

    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable String productId, @RequestBody Product payload) {
        if(service.update(productId, payload)!=null) {
            return ResponseEntity.of(Optional.of("product updated successfully! 🥳"));
        }
        return ResponseEntity.of(Optional.of("product to be updated does not exist 🙁"));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> patchProduct(@PathVariable String productId) {

        if(service.delete(productId)) {
            return ResponseEntity.of(Optional.of("product deleted successFully"));
        }
        return ResponseEntity.of(Optional.of("product cannot be deleted as it does not exist!"));
    }
}

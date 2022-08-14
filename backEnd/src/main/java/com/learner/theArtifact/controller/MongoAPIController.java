package com.learner.theArtifact.controller;

import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.service.MongoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongo")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class MongoAPIController {

    @Autowired
    private MongoProductService mongoProductService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        Product addedProduct = mongoProductService.add(product);

        return ResponseEntity.of(Optional.of("product added successfully!\nHere's the unique product Id -> " + addedProduct.get_id()));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> listProductsMongo() {
        List<Product> products = mongoProductService.list();
        if(!products.isEmpty())
            return ResponseEntity.ok(products);

        return new ResponseEntity(Optional.of("This should not have happened!"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProductMongo(@PathVariable String productId, @RequestBody Product payload) {
        if(mongoProductService.update(productId, payload)) {
            return ResponseEntity.of(Optional.of("product updated successfully! 🥳"));
        }
        return new ResponseEntity(Optional.of("This should not have happened!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> patchProduct(@PathVariable String productId) {

        if(mongoProductService.delete(productId)) {
            return ResponseEntity.of(Optional.of("product deleted successFully"));
        }
        return new ResponseEntity(Optional.of("This should not have happened!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

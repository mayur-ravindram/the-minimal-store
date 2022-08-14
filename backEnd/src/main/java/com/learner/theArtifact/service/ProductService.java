package com.learner.theArtifact.service;

import com.learner.theArtifact.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product add(Product product);

    List<Product> list();

    Product update(String productId, Product payload);

    boolean delete(String productId);
}

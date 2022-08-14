package com.learner.theArtifact.service;

import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.repository.MongoAPIRepository;

import java.util.List;

public interface MongoProductService {
    Product add(Product product);

    List<Product> list();

    boolean update(String productId, Product payload);

    boolean delete(String productId);
}

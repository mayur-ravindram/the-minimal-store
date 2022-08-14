package com.learner.theArtifact.repository;

import com.learner.theArtifact.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAPIRepository extends MongoRepository<Product, String> {
}

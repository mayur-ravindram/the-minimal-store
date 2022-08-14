package com.learner.theArtifact.repository;

import com.learner.theArtifact.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository extends CrudRepository<Product, Long> {
}

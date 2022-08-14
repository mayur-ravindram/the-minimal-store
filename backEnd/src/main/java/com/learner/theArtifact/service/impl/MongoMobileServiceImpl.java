package com.learner.theArtifact.service.impl;

import com.learner.theArtifact.exception.NoProductExistException;
import com.learner.theArtifact.exception.ProductAlreadyExistException;
import com.learner.theArtifact.exception.ProductDeletionException;
import com.learner.theArtifact.exception.ProductNotUpdatedException;
import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.repository.MongoAPIRepository;
import com.learner.theArtifact.service.MongoProductService;
import com.mongodb.client.result.UpdateResult;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoMobileServiceImpl implements MongoProductService {
    @Autowired
    private MongoAPIRepository repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Product add(Product product) {
        // todo -> handle duplicate
//        if(null != product.get_id() && null != repo.findById(product.get_id())) {
//            throw new ProductAlreadyExistException("1001", "Cannot add the same product again");
//        }
        return repo.save(product);
    }

    @Override
    public List<Product> list() {
        List<Product> products = repo.findAll();
        if(products.isEmpty())
            throw new NoProductExistException("1001", "No products in database!");
        return products;
    }

    @Override
    public boolean update(String productId, Product product) {
        Optional<Product> existingProduct = repo.findById(productId);
        if(existingProduct.isEmpty())
            throw new NoProductExistException("1002", "Can't do update on product that does not exisit in database!");

        Query query = new Query(Criteria.where("productId").is(product.get_id()));
        Update update = new Update();
        update.set("name", product.getName());
        update.set("category", product.getCategory());
        update.set("color", product.getColor());
        update.set("price", product.getPrice());

        UpdateResult updatedDocument = mongoTemplate.updateFirst(query, update, Product.class);
        if(updatedDocument==null)
            throw new ProductNotUpdatedException("1006", "Unable to update product details");
        return updatedDocument.getModifiedCount() > 0L;
    }

    @Override
    public boolean delete(String productId) {
        if(repo.findById(productId)==null)
            throw new ProductDeletionException("1007", "Error deleting product as it does not exist in database!");
        Query deleteQuery = new Query(Criteria.where("productId").is(productId));
        return mongoTemplate.remove(deleteQuery, Product.class).getDeletedCount()>1L;
    }
}

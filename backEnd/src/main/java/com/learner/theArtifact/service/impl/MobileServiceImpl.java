package com.learner.theArtifact.service.impl;

import com.learner.theArtifact.exception.NoProductExistException;
import com.learner.theArtifact.exception.ProductAlreadyExistException;
import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.repository.APIRepository;
import com.learner.theArtifact.repository.MongoAPIRepository;
import com.learner.theArtifact.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MobileServiceImpl implements ProductService {

    @Autowired
    private APIRepository repo;

    @Autowired
    private MongoAPIRepository mongoRepo;

    @Override
    public Product add(Product product) {
        List<Product> products = (List<Product>) repo.findAll();
        Product savedProduct = null;
        if(products.stream().filter(p -> p.get_id() == product.get_id()).findAny().isPresent()) {
            throw new ProductAlreadyExistException("1001", "the product cannot be added again as it already exists!");
        }
        savedProduct = repo.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> list() {
        List<Product> list = (List<Product>) this.repo.findAll();
        if(list.isEmpty())
            throw new NoProductExistException("1002", "the product list is empty!");
        return list;
    }

    @Override
    public Product update(String productId,Product payload) {
        List<Product> list = (List<Product>) repo.findAll();
        Optional<Product> existingProduct = list.stream().filter(product -> product.get_id() == productId ).findAny();
        if(existingProduct.isPresent() && existingProduct.get().get_id() == payload.get_id()) {
            return repo.save(payload);
        }
        throw new NoProductExistException("1003", "the product cannot be updated as it does not exist!");
    }

    @Override
    public boolean delete(String productId) {
        List<Product> list = (List<Product>) repo.findAll();

        Optional<Product> existingProduct = list.stream().filter(product -> product.get_id()==(productId)).findAny();
        if(existingProduct.isPresent()) {
            repo.delete(existingProduct.get());
            return true;
        }
        throw new NoProductExistException("1004", "the product cannot be deleted as it does not exist!");
    }
}

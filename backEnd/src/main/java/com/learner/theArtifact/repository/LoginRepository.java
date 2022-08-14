package com.learner.theArtifact.repository;

import com.learner.theArtifact.model.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<LoginRequest, Long> {

    @Query(value = "{'userName' : { $eq: ?0 } }")
    LoginRequest findByUsername(String userName);
}

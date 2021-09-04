package com.example.demo.repository;

import com.example.demo.model.driver.Offer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferRepository extends MongoRepository<Offer, ObjectId> {
    public Offer findById(String offerId);
}

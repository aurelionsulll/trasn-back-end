package com.example.demo.model.client;

import com.example.demo.model.driver.Location;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class Order {

    @Id
    private ObjectId id;
    private ObjectId offerId;
    private ObjectId userId;
    private Location destination;
    private Float price;
    private Date date;


    public Order() {
    }

    public Order(ObjectId offerId, ObjectId userId, Location destination, Float price, Date date) {
        this.offerId = offerId;
        this.userId = userId;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

    public Float getPrice() {
        return price;
    }

    public Order setPrice(Float price) {
        this.price = price;
        return this;
    }

    public ObjectId getId() {
        return id;
    }

    public Order setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public ObjectId getOfferId() {
        return offerId;
    }

    public Order setOfferId(ObjectId offerId) {
        this.offerId = offerId;
        return this;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public Order setUserId(ObjectId userId) {
        this.userId = userId;
        return this;
    }

    public Location getDestination() {
        return destination;
    }

    public Order setDestination(Location destination) {
        this.destination = destination;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Order setDate(Date date) {
        this.date = date;
        return this;
    }
}

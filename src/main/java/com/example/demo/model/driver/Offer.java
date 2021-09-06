package com.example.demo.model.driver;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Offer {

    @Id
    private ObjectId id;
    private ObjectId userId;
    private Location location;
    private String vehicle;
    private Boolean onDrive;
    private Boolean isApproved;
    private Boolean isActive;

    public Boolean getIsApproved() {
        return isApproved;
    }

    public Offer setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
        return this;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public Offer setApproved(Boolean approved) {
        isApproved = approved;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Offer setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Boolean getOnDrive() {
        return onDrive;
    }

    public Offer setOnDrive(Boolean onDrive) {
        this.onDrive = onDrive;
        return this;
    }

    public Offer() {
    }

    public Offer(ObjectId userId, Location location, String vehicle) {
        this.userId = userId;
        this.location = location;
        this.vehicle = vehicle;
        this.onDrive = false;
        this.isApproved = false;
        this.isActive = true;
    }

    public ObjectId getId() {
        return id;
    }

    public Offer setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public Offer setUserId(ObjectId userId) {
        this.userId = userId;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Offer setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getVehicle() {
        return vehicle;
    }

    public Offer setVehicle(String vehicle) {
        this.vehicle = vehicle;
        return this;
    }
}

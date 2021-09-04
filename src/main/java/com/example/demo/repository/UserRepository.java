package com.example.demo.repository;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByEmail (String email);

    List<User> findByUserType(UserType userType);

    User findById(String id);

}

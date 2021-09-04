package com.example.demo.resolver.user;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import com.example.demo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    public UserQueryResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }


    public List<User> allDrivers() {
        return userRepository.findByUserType(UserType.driver);
    }
    public List<User> allClients() {
        return userRepository.findByUserType(UserType.client);
    }

    public User user(String id) {
        return userRepository.findById(id);
    }

//    public User user(SignInPayload payload) {
//        return payload.getUser();
//    }
}

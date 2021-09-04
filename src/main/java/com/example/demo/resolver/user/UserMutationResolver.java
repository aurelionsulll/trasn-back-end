package com.example.demo.resolver.user;

import com.example.demo.model.user.AuthData;
import com.example.demo.model.user.SignInPayload;
import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import com.example.demo.repository.UserRepository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class UserMutationResolver implements GraphQLMutationResolver {
    private final UserRepository userRepository;

    public UserMutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserType userType,
                           String firstName,
                           String lastName,
                           String phone,
                           int age,
                           AuthData authData,
                           Boolean isApproved) {
        User user = new User(userType,
                firstName,
                lastName,
                authData.getEmail(),
                phone, age,
                authData.getPassword(),
                false);

     return userRepository.insert(user);
    }

    public SignInPayload signInUser(AuthData auth) throws IllegalAccessException {

        User user = userRepository.findByEmail(auth.getEmail());

        if (user.getPassword().equals(auth.getPassword())) {
            return new SignInPayload(user.getId().toString(), user);
        }

        throw new GraphQLException("Invalid credentials");
    }

}

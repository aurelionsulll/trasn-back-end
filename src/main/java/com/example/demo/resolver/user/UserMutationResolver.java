package com.example.demo.resolver.user;

import com.example.demo.model.user.*;
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
            CurrentUser currentUser = new CurrentUser(user);
            return new SignInPayload(user.getId().toString(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }



    public User editUser(String userId, String firstName, String lastName, String phone, int age, String password) {

        User user = userRepository.findById(userId);

        if (!firstName.isEmpty()) user.setFirstName(firstName);
        if (!lastName.isEmpty()) user.setLastName(lastName);
        if (!phone.isEmpty()) user.setPhone(phone);
        if (age != 0) user.setAge(age);
        if (!password.isEmpty()) user.setPassword(password);

        return userRepository.save(user);

    }

    public User approveUser(String userId) {
       return userRepository.save(userRepository.findById(userId).setApproved(true));
    }

    public User blockUser(String userId) {
        return userRepository.save(userRepository.findById(userId).setApproved(false));
    }

}

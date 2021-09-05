package com.example.demo.resolver.client;

import com.example.demo.model.client.Order;
import com.example.demo.model.driver.Offer;
import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderQueryResolver implements GraphQLQueryResolver {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    public OrderQueryResolver(OrderRepository orderRepository, UserRepository userRepository, OfferRepository offerRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    public Order order(String orderId, String userId) {

        Order order = orderRepository.findById(orderId);
        User user = userRepository.findById(userId);
        Offer offer = offerRepository.findById(order.getOfferId().toString());
        if (user.getId().toString()
                .equals(order.getUserId().toString()) ||
                user.getId().toString().equals(offer.getUserId().toString()) ||
                user.getUserType().equals(UserType.admin)
        ) {
            return order;
        }
        return new Order();

    }


}

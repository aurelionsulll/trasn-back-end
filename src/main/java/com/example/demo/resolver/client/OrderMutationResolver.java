package com.example.demo.resolver.client;

import com.example.demo.model.client.Order;
import com.example.demo.model.driver.Location;
import com.example.demo.model.driver.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.OrderRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ComponentScan
public class OrderMutationResolver implements GraphQLMutationResolver {

    private final OrderRepository orderRepository;
    private final OfferRepository offerRepository;

    public OrderMutationResolver(OrderRepository orderRepository, OfferRepository offerRepository) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
    }

    public Order createOrder(String offerId, String userId, Location destination) {

        Offer offer = offerRepository.findById(offerId);

        Float price = (float)distance(Double.parseDouble(offer.getLocation().getLatitude()), Double.parseDouble(offer.getLocation().getLongitude()),
                Double.parseDouble(destination.getLatitude()) , Double.parseDouble(destination.getLongitude()), "K") * 10;

        Order order = new Order(new ObjectId(offerId), new ObjectId(userId), destination, price, new Date());
        return orderRepository.insert(order);
    }


    private static double distance(double latFrom, double longFrom, double latDestination, double longDestination, String unit) {
        if ((latFrom == latDestination) && (longFrom == longDestination)) {
            return 0;
        }
        else {
            double theta = longFrom - longDestination;
            double dist = Math.sin(Math.toRadians(latFrom)) * Math.sin(Math.toRadians(latDestination)) + Math.cos(Math.toRadians(latFrom)) * Math.cos(Math.toRadians(latDestination)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }



}

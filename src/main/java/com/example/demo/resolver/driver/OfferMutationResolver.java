package com.example.demo.resolver.driver;

import com.example.demo.model.driver.Location;
import com.example.demo.model.driver.Offer;
import com.example.demo.model.user.User;
import com.example.demo.model.user.UserType;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class OfferMutationResolver implements GraphQLMutationResolver {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    public OfferMutationResolver(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    public Offer createOffer(String userId, Location location, String vehicle) {
        User user = userRepository.findById(userId);
        if (user.isApproved()) {
            if (user.getUserType() == UserType.driver) {
                Offer offer = new Offer(new ObjectId(userId), location, vehicle);
                return offerRepository.insert(offer);
            }
            return new Offer();
        }
        return new Offer();
    }

    public Offer approveOffer(String offerId) {
        Offer offer = offerRepository.findById(offerId);
        offer.setIsApproved(true);
        return offerRepository.save(offer);
    }

    public Offer onDrive(String offerId) {
        Offer offer = offerRepository.findById(offerId);
        offer.setOnDrive(true);
        return offerRepository.save(offer);
    }

//    public Offer deleteOffer(String offerId) {
//        Offer offer = offerRepository.findById(offerId);
//        offerRepository.delete(offer);
//        return offer;
//    }



}

package com.example.demo.resolver.driver;

import com.example.demo.model.driver.Offer;
import com.example.demo.model.user.User;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OfferQueryResolver implements GraphQLQueryResolver {

    private final OfferRepository offerRepository;

    public OfferQueryResolver(OfferRepository offerRepository,UserRepository userRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> allOffers(){
        return offerRepository.findAll();
    }

    public Offer offer(String offerId) {
        return offerRepository.findById(offerId);
    }

//    public Optional<User> postedBy(Offer offer) {
//        if(offer.getUserId() == null){ return null;};
//        userRepository.findById(offer.getUserId());
//        return userRepository.findById(offer.getUserId());
//    }


}

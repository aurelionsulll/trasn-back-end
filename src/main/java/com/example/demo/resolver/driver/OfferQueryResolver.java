package com.example.demo.resolver.driver;

import com.example.demo.model.driver.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferQueryResolver implements GraphQLQueryResolver {

    private final OfferRepository offerRepository;

    public OfferQueryResolver(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> allOffers() {
        return offerRepository.findAll();
    }

    public Offer offer(String offerId) {
        return offerRepository.findById(offerId);
    }


}

package com.company.Offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferStrategyFactoryImpl implements OfferStrategyFactory {
    /**
     * This implementation should contain some dependencies to rules
     * These rules determine which offer strategy to create for an order item
     * For example : What are the rules for a 2 for 1 strategy or 3rd item for free
     *
     * For now we'll hard code rules here and we will generate strategies for each case
     * Another idea would be to generate random offerStrategies for each product */

    public OfferStrategy create(long barcode) {
        return null;
    }
}

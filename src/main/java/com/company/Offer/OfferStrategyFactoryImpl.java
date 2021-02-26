package com.company.Offer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferStrategyFactoryImpl implements OfferStrategyFactory {
    /**
     * This implementation should contain some dependencies to rules
     * These rules determine which offer strategy to create for an order item
     * For example : What are the rules for a 2 for 1 strategy or 3rd item for free
     * <p>
     * For now we'll hard code rules here and we will generate strategies for each case
     * Another idea would be to generate random offerStrategies for each product
     */
    public OfferStrategy create(long barcode) {
        if (barcode < 5000) {
            return new NormalOfferStrategy();
        } else if (barcode < 10000) {
            return new ThirdOneFreeOfferStrategy();
        } else if (barcode<15000){
            return new BigQuantityOfferStrategy(10,0.1);
        }
        return null;
    }
}

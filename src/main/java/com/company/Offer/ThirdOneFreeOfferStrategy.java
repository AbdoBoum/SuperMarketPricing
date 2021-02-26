package com.company.Offer;

import com.company.Entities.Price;
import com.company.Order.OrderItem;

import java.math.BigDecimal;

public class ThirdOneFreeOfferStrategy implements OfferStrategy {

    @Override
    public Price getPrice(OrderItem orderItem) {
        Price normalPrice = orderItem.getUnitPrice();
        if (orderItem.getQuantity() < 1) {
            throw new IllegalStateException("minimum quantity must be 1");
        }
        int numberOfFreeProducts = (int) orderItem.getQuantity() / 3;
        int numberOfFullPriceProducts = orderItem.getQuantity() % 3;

        return Price.of(
                normalPrice
                        .mult(numberOfFullPriceProducts)
                        .add(normalPrice
                                .mult(2)
                                .mult(numberOfFreeProducts))
                        .getAmount());

    }
}

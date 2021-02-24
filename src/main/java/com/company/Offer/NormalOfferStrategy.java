package com.company.Offer;

import com.company.Entities.Price;
import com.company.Order.OrderItem;

public class NormalOfferStrategy implements OfferStrategy {

    public Price getPrice(OrderItem item) {
        return item.getPrice().mult(item.getQuantity());
    }
}

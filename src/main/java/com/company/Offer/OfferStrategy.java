package com.company.Offer;

import com.company.Entities.Price;
import com.company.Order.OrderItem;

public interface OfferStrategy {

    public Price getPrice(OrderItem item);

}

package com.company.Offer;

import com.company.Entities.Price;
import com.company.Order.OrderItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BigQuantityOfferStrategy implements OfferStrategy{

    private int minimumQuantity;
    private double discount;

    @Override
    public Price getPrice(OrderItem orderItem) {

        Price normalPrice = orderItem.getUnitPrice();
        if (orderItem.getQuantity()>=this.minimumQuantity) {
            return Price.of(normalPrice.mult(orderItem.getQuantity()).mult(1-this.discount).getAmount());
        }
        return Price.of(normalPrice.mult(orderItem.getQuantity()).getAmount());

    }
}

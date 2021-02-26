package com.company.Order;

import com.company.Entities.Price;
import com.company.Offer.OfferStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private long productBarCode;

    private Price unitPrice;

    private int quantity;

    private OfferStrategy offerStrategy;

    public Price getPrice() {
        return offerStrategy.getPrice(this);
    }

    public void addQuantity(int units) {
        if (units < 1)
            throw new IllegalArgumentException("units must be positive");
        quantity += units;
    }

    @Override
    public boolean equals(Object o){
        if (o ==this){
            return true;
        }
        if(!(o instanceof OrderItem)) {
            return false;
        }

        OrderItem orderItem = (OrderItem) o;

        return this.getProductBarCode() == orderItem.getProductBarCode();
    }

}

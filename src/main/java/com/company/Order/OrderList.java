package com.company.Order;

import com.company.Entities.Price;
import com.company.Entities.Product;
import com.company.Offer.OfferStrategy;
import com.company.Offer.OfferStrategyFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {

    private List<OrderItem> orderItems;
    private OfferStrategyFactory offerStrategyFactory;


    public void addOrderItem(Product product, int units){

        OrderItem existingOrderItem = orderItems.stream()
                .filter(oi->product.equals(oi))
                .findAny()
                .orElse(null);

        if (existingOrderItem !=null){
            existingOrderItem.addQuantity(units);
        }else{
            OfferStrategy offerStrategy = offerStrategyFactory.create(product.getBarCode());
            OrderItem newOrderItem = new OrderItem(product.getBarCode(),product.getUnitPrice(),units,offerStrategy);
            orderItems.add(newOrderItem);
        }
    }

    public Price getTotalPrice(){

        Price totalPrice = Price.of(0);

        for(OrderItem oi : orderItems){
            totalPrice.add(oi.getPrice());
        }

        return totalPrice;
    }
}

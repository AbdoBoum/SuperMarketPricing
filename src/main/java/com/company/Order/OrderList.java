package com.company.Order;

import com.company.Entities.Price;
import com.company.Entities.Product;
import com.company.Offer.OfferStrategy;
import com.company.Offer.OfferStrategyFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {

    private List<OrderItem> orderItems;
    private OfferStrategyFactory offerStrategyFactory;

    public OrderList(OfferStrategyFactory offerStrategyFactory) {
        this.offerStrategyFactory = offerStrategyFactory;
        this.orderItems = new ArrayList<>();
    }

    public void addOrderItem(Product product, int units){

        OrderItem existingOrderItem = orderItems.stream()
                .filter(oi->product.getBarCode()==oi.getProductBarCode())
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

        for(OrderItem oi : this.getOrderItems()){
            totalPrice = totalPrice.add(oi.getPrice());
            //System.out.println("Order List getTotalPrice method : "+oi.getPrice().getAmount().toString());

        }
        //System.out.println("Order List getTotalPrice method return : "+totalPrice.getAmount().toString());
        return totalPrice;
    }
}

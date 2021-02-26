package com.company.Entities;

import com.company.Order.OrderItem;

import java.math.BigDecimal;

public class Price {

    private BigDecimal amount;

    private Price(BigDecimal amount) {
        this.amount = amount.stripTrailingZeros();
    }

    public static Price of(BigDecimal amount) {
        return new Price(amount);
    }

    public static Price of(long amount) {
        BigDecimal bigDecimalAmount = BigDecimal.valueOf(amount);
        return of(bigDecimalAmount);
    }

    public Price add(Price p) {
        return new Price(amount.add(p.amount));
    }

    public Price sub(Price p) {
        return new Price(amount.add(p.amount));
    }

    public Price mult(long multiplier) {
        return new Price(amount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public Price mult(double multiplier) {
        return new Price(amount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o){
        if (o ==this){
            return true;
        }
        if(!(o instanceof Price)) {
            return false;
        }

        Price price = (Price) o;

        return this.getAmount().equals(price.getAmount());
    }
}

package com.ddd.studyddd.order.command.domain;

import com.ddd.studyddd.domain.entity.Money;
import com.ddd.studyddd.catalog.command.domain.product.Product;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public int getAmounts(){
        return amounts.getValue();
    }
}

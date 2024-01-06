package com.ddd.studyddd.domain.entity;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public Money addMoney(Money money){
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier){
        return new Money(value * multiplier);
    }
}

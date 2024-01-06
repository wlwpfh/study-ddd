package com.ddd.studyddd.domain.entity;

public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void chagneShippingInfo(ShippingInfo newShippingInfo){
        if(!isShippingChangeable()){
          throw new IllegalStateException("Can't change shipping in " + state);
        }
        this.shippingInfo = newShippingInfo;
    }

    public boolean isShippingChangeable(){
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }
    public enum OrderState {
        PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED;
    }
}

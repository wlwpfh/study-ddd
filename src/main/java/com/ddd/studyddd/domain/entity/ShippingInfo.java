package com.ddd.studyddd.domain.entity;

import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}

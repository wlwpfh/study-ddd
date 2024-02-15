package com.ddd.studyddd.order.command.domain;

import com.ddd.studyddd.domain.entity.Address;
import com.ddd.studyddd.domain.entity.Receiver;
import lombok.Getter;

@Getter
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}

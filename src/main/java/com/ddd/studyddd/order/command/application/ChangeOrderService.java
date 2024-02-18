package com.ddd.studyddd.order.command.application;

import com.ddd.studyddd.member.command.domain.Member;
import com.ddd.studyddd.order.command.domain.Order;
import com.ddd.studyddd.order.command.domain.OrderId;
import com.ddd.studyddd.order.command.domain.ShippingInfo;
import org.springframework.transaction.annotation.Transactional;

public class ChangeOrderService {
    @Transactional
    public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr){
        Order order = orderRepository.findById(id);
        if(order == null) {
            throw new OrderNotFoundException();
        }
        order.shipTo(newShippingInfo);
        if(useNewShippingAddrAsMemberAddr){
            Member member = memberRepository.findById(order.getOrderer().getMemberId());
            member.changeAddress(newShippingInfo.getAddress());
        }
    }
}

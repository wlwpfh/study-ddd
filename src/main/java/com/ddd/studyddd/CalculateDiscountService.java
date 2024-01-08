package com.ddd.studyddd;

import com.ddd.studyddd.domain.entity.Money;
import com.ddd.studyddd.domain.entity.OrderLine;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class CalculateDiscountService {
    private DroolsRuleEngine ruleEngine;

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId){
        Customer customer = findCustomer(customerId);

        MutableMoney money = new MutableMoney(0);
        List<?> facts = Arrays.asList(customer, money);
        facts.addAll(orderLines);
        ruleEngine.evaluate("discountCalculation", facts);
        return money.toImmutableMoney();
    }
}

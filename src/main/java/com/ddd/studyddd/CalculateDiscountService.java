package com.ddd.studyddd;

import com.ddd.studyddd.domain.entity.Money;
import com.ddd.studyddd.domain.entity.OrderLine;
import lombok.CustomLog;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class CalculateDiscountService {
    private final DroolsRuleEngine ruleEngine;
    private final RuleDiscounter ruleDiscounter;
    private final CustomerRepository customerRepository;

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId){
        Customer customer = findCustomer(customerId);

        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId){
        Customer customer = customerRepository.findById(customerId);
        if(customer == null){
            throw new NoCustomerException();
        }
        return customer;
    }
}

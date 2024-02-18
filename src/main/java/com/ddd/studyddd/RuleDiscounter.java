package com.ddd.studyddd;

import com.ddd.studyddd.domain.entity.Money;
import com.ddd.studyddd.order.command.domain.OrderLine;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLines);
}

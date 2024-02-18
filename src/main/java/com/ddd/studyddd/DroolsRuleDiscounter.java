package com.ddd.studyddd;

import com.ddd.studyddd.domain.entity.Money;
import com.ddd.studyddd.order.command.domain.OrderLine;

import java.util.List;

public class DroolsRuleDiscounter implements RuleDiscounter {
    private KieContainer kieContainer;

    public DroolsRuleEngine(){
        KieServices ks = KieServices.Factory.get();
        kieContainer = ks.getKieClasspathContainer();
    }
    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        KieSession kSession = kieContainer.newKieSession("discountSession");
        try{
            kSession.fireAllRules();
        } finally {
            kSession.dispose();
        }
        return money.toImmutableMoney();
    }
}

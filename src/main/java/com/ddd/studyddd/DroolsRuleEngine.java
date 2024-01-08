package com.ddd.studyddd;

import lombok.RequiredArgsConstructor;

import java.util.List;

public class DroolsRuleEngine {
    private  KieContainer kieContainer;

    public DroolsRuleEngine(){
        KieService ks = KieServices.Factory.get();
        kieContainer = ks.getKieClasspathContainer();
    }

    public void evaluate(String sessionName, List<?> facts){
        KieSession kieSession = kieContainer.newKieSession(sessionName);
        try{
            facts.forEach(x -> kieSession.insert(x));
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
    } // 별도 파일을 작성한 규칙을 이용해 연산을 수행하는 코드
}

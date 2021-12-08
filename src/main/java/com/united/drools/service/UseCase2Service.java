package com.united.drools.service;

import com.united.drools.entity.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UseCase2Service {

    private final KieContainer kieContainer;

    private final String URI_TO = "http://localhost:8080";

    @Autowired
    private RestTemplate restTemplate;

    public UseCase2Service(KieContainer kieContainer) {

        this.kieContainer = kieContainer;
    }

    public void fireFareLockRules(PNRData pnrData) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(pnrData); // object to validate
        kieSession.fireAllRules(); // fire all rules defined in drl
        kieSession.dispose();
    }

    public void fireNotificationRules(Rule2Response rr) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(rr);
        //kieSession.insert(reward);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    /*public void invokeStatelessSession(Rule2Response rr){
        StatelessKieSession s = kieContainer.newStatelessKieSession();
        s.execute(rr);
        System.out.println();
    }*/

    public Sale invokeRestCall(String flag){
        try{
            Map<String,String> params = new HashMap<String, String>();
            params.put("flag",flag);
            Sale sale = restTemplate.getForObject(URI_TO+"/discount/{flag}", Sale.class, params);
            System.out.println("Got response from REST api "+sale.getDiscount());
            return sale;

        }catch(Exception ex){
            System.out.println("Exception occurred while calling external api call.. EXT101");
            ex.printStackTrace();
        }
        return null;
    }

    public Reward callRewardsApp(String flag){
        try{
            Map<String,String> params = new HashMap<String, String>();
            params.put("flag",flag);
            Reward reward = restTemplate.getForObject(URI_TO+"/getRewardPoints/{flag}", Reward.class, params);
            return reward;
        }catch(Exception ex){
            System.out.println(ex.getMessage()+" > Exception occurred while calling external api call.. EXT101 >"+flag);
            //ex.printStackTrace();
        }
        return null;
    }

    public void fireCustomerCategoryRules(Customer customer) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(customer);
        kieSession.fireAllRules();
        kieSession.dispose();
    }



}

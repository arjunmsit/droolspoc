package com.united.drools.service;

import com.united.drools.entity.PNRData;
import com.united.drools.entity.Reward;
import com.united.drools.entity.Rule2Response;
import com.united.drools.entity.Sale;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
        kieSession.insert(pnrData);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public void fireNotificationRules(Rule2Response rr) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(rr);
        //kieSession.insert(reward);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    public Sale invokeRestCall(String flag){
        try{
            /*UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("localhost:8080/discount/"+flag);
            if(flag != null){
                builder.queryParam("flag", flag);
            }*/
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




}

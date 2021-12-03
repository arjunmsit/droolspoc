package com.united.drools.controller;

import com.united.drools.entity.PNRData;
import com.united.drools.entity.Reward;
import com.united.drools.entity.Rule2Response;
import com.united.drools.entity.Sale;
import com.united.drools.service.UseCase2Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UseCase2Controller {

    //private static final String eventType = "";
    private UseCase2Service useCase2Service;
    private Reward reward;

    public UseCase2Controller(UseCase2Service service) {
        this.useCase2Service = service;
    }

    @PostMapping("/usecase2")
    public ResponseEntity<?> getDiscountPercent(@RequestBody PNRData pnrData) {
        this.useCase2Service.fireFareLockRules(pnrData);
        System.out.println(pnrData.getEventType());
        Reward rewardResp = null;
        Rule2Response rule2Response = new Rule2Response();
        if(pnrData.getEventType().equalsIgnoreCase("PURCHASE_EVENT")){
            reward =  useCase2Service.callRewardsApp("PASS");
        }
        if(pnrData.getEventType().equalsIgnoreCase("EXPIRE_EVENT")){
            reward = useCase2Service.callRewardsApp("FAIL");
        }
        rule2Response.setPassenger(pnrData);
        rule2Response.setReward(reward);
        useCase2Service.fireNotificationRules(rule2Response);

        return new ResponseEntity<Rule2Response>(rule2Response,null, HttpStatus.OK);
        // pnrData.getEventType();
    }

}
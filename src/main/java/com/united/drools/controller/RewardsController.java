package com.united.drools.controller;

import com.united.drools.entity.Reward;
import com.united.drools.service.RewardsService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardsController {
    private RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService){
        this.rewardsService = rewardsService;
    }

    @GetMapping("/getRewardPoints/{flag}")
    public ResponseEntity<Reward> getRewardPoints(@PathVariable String flag){
            if(flag.equalsIgnoreCase("PASS")){
                Reward s = rewardsService.getRewardPoints();
                return new ResponseEntity<Reward>(s, HttpStatus.OK);
            }else{
                throw new ResourceNotFoundException();
            }
    }

}

package com.united.drools.service;

import com.united.drools.entity.Reward;
import org.springframework.stereotype.Service;

@Service
public class RewardsService {

    public Reward getRewardPoints() {
        Reward r = new Reward();
        r.setStatus("POINTS_ADDED");
        r.setDescription("External API call successful to Rewards");
        r.setPoints(10);
        r.setPointsAdded(true);
        return r;
    }

}

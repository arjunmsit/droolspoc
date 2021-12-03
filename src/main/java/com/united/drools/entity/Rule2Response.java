package com.united.drools.entity;

public class Rule2Response {
    private PNRData passenger;
    private Reward reward ;
    private String results;
    private String errorMessage;

    public PNRData getPassenger() {
        return passenger;
    }

    public void setPassenger(PNRData passenger) {
        this.passenger = passenger;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

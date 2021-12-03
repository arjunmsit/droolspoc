package com.united.drools.entity;

public class Segment {

    private int flightNumber;
    private String origin;
    private String destination;
    private String carrierCode;
    private String currentServiceClass;
    private String bookedServiceClass;
    private String actionCode;
    private String prevActionCode;
    private String advanceSeatNum;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCurrentServiceClass() {
        return currentServiceClass;
    }

    public void setCurrentServiceClass(String currentServiceClass) {
        this.currentServiceClass = currentServiceClass;
    }

    public String getBookedServiceClass() {
        return bookedServiceClass;
    }

    public void setBookedServiceClass(String bookedServiceClass) {
        this.bookedServiceClass = bookedServiceClass;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getPrevActionCode() {
        return prevActionCode;
    }

    public void setPrevActionCode(String prevActionCode) {
        this.prevActionCode = prevActionCode;
    }

    public String getAdvanceSeatNum() {
        return advanceSeatNum;
    }

    public void setAdvanceSeatNum(String advanceSeatNum) {
        this.advanceSeatNum = advanceSeatNum;
    }
}

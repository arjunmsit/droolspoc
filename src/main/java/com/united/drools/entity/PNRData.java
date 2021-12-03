package com.united.drools.entity;

public class PNRData {

    private String recordLocator;
    private String pnrCreationDate;
    private int numInParty;
    private int numOfSegments;
    private String ticketTypeIndicator;
    private String ticketText;
    private String fareLockType;
    private Passenger passenger;
    private PNRContactData pnrContactData;
    private String eventType;


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRecordLocator() {
        return recordLocator;
    }

    public void setRecordLocator(String recordLocator) {
        this.recordLocator = recordLocator;
    }

    public String getPnrCreationDate() {
        return pnrCreationDate;
    }

    public void setPnrCreationDate(String pnrCreationDate) {
        this.pnrCreationDate = pnrCreationDate;
    }

    public int getNumInParty() {
        return numInParty;
    }

    public void setNumInParty(int numInParty) {
        this.numInParty = numInParty;
    }

    public int getNumOfSegments() {
        return numOfSegments;
    }

    public void setNumOfSegments(int numOfSegments) {
        this.numOfSegments = numOfSegments;
    }

    public String getTicketTypeIndicator() {
        return ticketTypeIndicator;
    }

    public void setTicketTypeIndicator(String ticketTypeIndicator) {
        this.ticketTypeIndicator = ticketTypeIndicator;
    }

    public String getTicketText() {
        return ticketText;
    }

    public void setTicketText(String ticketText) {
        this.ticketText = ticketText;
    }

    public String getFareLockType() {
        return fareLockType;
    }

    public void setFareLockType(String fareLockType) {
        this.fareLockType = fareLockType;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public PNRContactData getPnrContactData() {
        return pnrContactData;
    }

    public void setPnrContactData(PNRContactData pnrContactData) {
        this.pnrContactData = pnrContactData;
    }
}

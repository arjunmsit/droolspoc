package com.united.drools.entity;

public class Passenger {
    private String surname;
    private String firstName;
    private String lastName;
    private int eliteStatusCode;
    private int lastNamePos;
    private int firstNamePos;

    private Segment segment;

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public PNRContactData getTravelContactData() {
        return travelContactData;
    }

    public void setTravelContactData(PNRContactData travelContactData) {
        this.travelContactData = travelContactData;
    }

    private PNRContactData travelContactData;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEliteStatusCode() {
        return eliteStatusCode;
    }

    public void setEliteStatusCode(int eliteStatusCode) {
        this.eliteStatusCode = eliteStatusCode;
    }

    public int getLastNamePos() {
        return lastNamePos;
    }

    public void setLastNamePos(int lastNamePos) {
        this.lastNamePos = lastNamePos;
    }

    public int getFirstNamePos() {
        return firstNamePos;
    }

    public void setFirstNamePos(int firstNamePos) {
        this.firstNamePos = firstNamePos;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

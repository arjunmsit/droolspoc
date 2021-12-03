package com.united.drools.entity;

public class Reward {

    private String description;
    private int points;
    private String status;
    private boolean pointsAdded;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPointsAdded() {
        return pointsAdded;
    }

    public void setPointsAdded(boolean pointsAdded) {
        this.pointsAdded = pointsAdded;
    }
}

package com.rto.model;

public class Vehicle {
    private int vehicleId;
    private String regNo;
    private String type;
    private String model;
    private int ownerId;

    public Vehicle(int vehicleId, String regNo, String type, String model, int ownerId) {
        this.vehicleId = vehicleId;
        this.regNo = regNo;
        this.type = type;
        this.model = model;
        this.ownerId = ownerId;
    }

    public Vehicle(String regNo, String type, String model, int ownerId) {
        this(0, regNo, type, model, ownerId);
    }

    public int getVehicleId() { return vehicleId; }
    public String getRegNo() { return regNo; }
    public String getType() { return type; }
    public String getModel() { return model; }
    public int getOwnerId() { return ownerId; }

    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
    public void setType(String type) { this.type = type; }
    public void setModel(String model) { this.model = model; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    @Override
    public String toString() {
        return vehicleId + " | " + regNo + " | " + type + " | " + model + " | Owner: " + ownerId;
    }
}

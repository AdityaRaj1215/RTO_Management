package com.rto.model;

import java.time.LocalDate;

public class Registration {
    private int registrationId;
    private int vehicleId;
    private LocalDate registrationDate;
    private LocalDate expiryDate;

    public Registration() {}

    public Registration(int registrationId, int vehicleId, LocalDate registrationDate, LocalDate expiryDate) {
        this.registrationId = registrationId;
        this.vehicleId = vehicleId;
        this.registrationDate = registrationDate;
        this.expiryDate = expiryDate;
    }

    public Registration(int vehicleId, LocalDate registrationDate, LocalDate expiryDate) {
        this.vehicleId = vehicleId;
        this.registrationDate = registrationDate;
        this.expiryDate = expiryDate;
    }

    public int getRegistrationId() { return registrationId; }
    public void setRegistrationId(int registrationId) { this.registrationId = registrationId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    @Override
    public String toString() {
        return "Registration [registrationId=" + registrationId +
                ", vehicleId=" + vehicleId +
                ", registrationDate=" + registrationDate +
                ", expiryDate=" + expiryDate + "]";
    }
}

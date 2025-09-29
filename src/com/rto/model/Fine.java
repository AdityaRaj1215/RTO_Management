package com.rto.model;

import java.time.LocalDate;

public class Fine {
    private int fineId;
    private int ownerId;
    private String reason;
    private double amount;
    private LocalDate fineDate;

    // Constructor for inserting new fines
    public Fine(int ownerId, String reason, double amount, LocalDate fineDate) {
        this.ownerId = ownerId;
        this.reason = reason;
        this.amount = amount;
        this.fineDate = fineDate;
    }

    // Constructor for fetching from DB
    public Fine(int fineId, int ownerId, String reason, double amount, LocalDate fineDate) {
        this.fineId = fineId;
        this.ownerId = ownerId;
        this.reason = reason;
        this.amount = amount;
        this.fineDate = fineDate;
    }

    // Getters & setters
    public int getFineId() { return fineId; }
    public void setFineId(int fineId) { this.fineId = fineId; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getFineDate() { return fineDate; }
    public void setFineDate(LocalDate fineDate) { this.fineDate = fineDate; }

    @Override
    public String toString() {
        return "Fine{" +
                "fineId=" + fineId +
                ", ownerId=" + ownerId +
                ", reason='" + reason + '\'' +
                ", amount=" + amount +
                ", fineDate=" + fineDate +
                '}';
    }
}

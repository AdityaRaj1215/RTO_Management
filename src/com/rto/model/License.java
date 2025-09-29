package com.rto.model;

import java.time.LocalDate;

public class License {
    private int licenseId;
    private String licenseNumber;
    private int ownerId;
    private String type;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public License() {}

    public License(int licenseId, String licenseNumber, int ownerId, String type, LocalDate issueDate, LocalDate expiryDate) {
        this.licenseId = licenseId;
        this.licenseNumber = licenseNumber;
        this.ownerId = ownerId;
        this.type = type;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public License(String licenseNumber, int ownerId, String type, LocalDate issueDate, LocalDate expiryDate) {
        this.licenseNumber = licenseNumber;
        this.ownerId = ownerId;
        this.type = type;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public int getLicenseId() { return licenseId; }
    public void setLicenseId(int licenseId) { this.licenseId = licenseId; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    @Override
    public String toString() {
        return "License [licenseId=" + licenseId + ", licenseNumber=" + licenseNumber +
                ", ownerId=" + ownerId + ", type=" + type +
                ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + "]";
    }
}

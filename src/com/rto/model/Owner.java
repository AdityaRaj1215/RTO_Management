package com.rto.model;

public class Owner {
    private int ownerId;
    private String name;
    private String address;
    private String phone;

    public Owner() {}

    public Owner(int ownerId, String name, String address, String phone) {
        this.ownerId = ownerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Owner(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Owner [ownerId=" + ownerId + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
    }
}

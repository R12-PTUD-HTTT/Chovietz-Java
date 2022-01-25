package com.chovietz.model;

public class Receiver {
    private String name;
    private String phone_number;
    private String city;
    private String district;
    private String ward;
    private String street;
    public String getName() {
        return name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getPhong_number() {
        return phone_number;
    }
    public void setPhong_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setName(String name) {
        this.name = name;
    }

}

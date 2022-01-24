package com.chovietz.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Shipper extends User {
    private String name=null;
    private String phone_number=null;
    private String work_city;
    private String work_district;
    private String work_ward;
    public String getName() {
        return name;
    }
    public String getWork_ward() {
        return work_ward;
    }
    public void setWork_ward(String work_ward) {
        this.work_ward = work_ward;
    }
    public String getWork_district() {
        return work_district;
    }
    public void setWork_district(String work_district) {
        this.work_district = work_district;
    }
    public String getWork_city() {
        return work_city;
    }
    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }
    public String getPhoneNumber() {
        return phone_number;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

}

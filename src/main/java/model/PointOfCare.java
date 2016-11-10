package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCare implements ApplicationModel{

    // Attributes

    private int id;
    private int phoneDdd;
    private int phoneNumber;
    private String street;
    private int number;
    private String district;

    // Relations

    private PointOfCareType pointOfCareType;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneDdd() {
        return phoneDdd;
    }

    public void setPhoneDdd(int phoneDdd) {
        this.phoneDdd = phoneDdd;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public PointOfCareType getPointOfCareType() {
        return pointOfCareType;
    }

    public void setPointOfCareType(PointOfCareType pointOfCareType) {
        this.pointOfCareType = pointOfCareType;
    }

    @Override
    public boolean isValid() {
        return true; // TODO Implement
    }
}

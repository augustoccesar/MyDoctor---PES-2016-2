package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class PhoneNumber implements ApplicationModel {

    // Attributes

    private int id;
    private int ddi;
    private int ddd;
    private int number;
    private String type;

    // Relation

    private Person person;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean isValid() {
        return true; // TODO Implement
    }
}

package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 11/3/16.
 */
public class PointOfCareType implements ApplicationModel{

    // Attributes

    private int id;
    private String name;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isValid() {
        return true; // TODO Implement
    }
}

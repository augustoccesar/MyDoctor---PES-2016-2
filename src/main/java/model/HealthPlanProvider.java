package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class HealthPlanProvider implements ApplicationModel{

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
        return name != null && !name.isEmpty() && !name.trim().equals("");
    }
}

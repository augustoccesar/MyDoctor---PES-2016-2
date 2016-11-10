package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class Patient implements ApplicationModel{

    // Attributes

    private int id;

    // Relations

    private User user;
    private HealthPlan healthPlan;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HealthPlan getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(HealthPlan healthPlan) {
        this.healthPlan = healthPlan;
    }

    @Override
    public boolean isValid() {
        return true; // TODO Implement
    }
}


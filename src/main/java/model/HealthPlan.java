package model;

import java.util.Date;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class HealthPlan {

    // Attributes

    private int id;
    private String name;
    private String number;
    private Date startDate;
    private Date endDate;

    // Relation

    private HealthPlanProvider healthPlanProvider;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HealthPlanProvider getHealthPlanProvider() {
        return healthPlanProvider;
    }

    public void setHealthPlanProvider(HealthPlanProvider healthPlanProvider) {
        this.healthPlanProvider = healthPlanProvider;
    }
}

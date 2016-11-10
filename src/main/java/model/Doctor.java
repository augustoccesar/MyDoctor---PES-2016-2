package model;

import model.base.ApplicationModel;

import java.util.List;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class Doctor implements ApplicationModel {

    // Attributes

    private int id;
    private String boardNumber;

    // Relations

    private Person person;
    private List<Expertise> expertiseList;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public boolean isValid() {
        return true; // TODO Implement
    }
}

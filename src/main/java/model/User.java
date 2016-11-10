package model;

import model.base.ApplicationModel;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class User implements ApplicationModel{

    // Attributes

    private int id;
    private String email;
    private String encryptedPassword;

    // Relations

    private Person person;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
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

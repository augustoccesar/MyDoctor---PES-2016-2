package model;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class Doctor {

    // Attributes

    private int id;
    private String boardNumber;

    // Relations

    private Person person;

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
}

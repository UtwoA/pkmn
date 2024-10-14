package ru.mirea.pkmn;

import java.io.Serializable;

public class Student  implements Serializable {
    private String firstName;
    private String surName;

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getFamilyName() {
        return patronymic;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return firstName + " / " + surName + " / " + patronymic + " / " + group;
    }

    private static final long serialVersionUID = 1L;
    private String patronymic;
    private String group;

    public Student(String firstName, String surName, String familyName, String group) {
        this.firstName = firstName;
        this.surName = surName;
        this.patronymic = familyName;
        this.group = group;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setFamilyName(String familyName) {
        this.patronymic = familyName;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}


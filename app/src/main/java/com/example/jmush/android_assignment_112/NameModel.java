package com.example.jmush.android_assignment_112;

/**
 * Created by jmush on 9/9/17.
 */

public class NameModel {

    int id;
    String name;
    String lastName;


    public NameModel(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    public NameModel(int id, String name,String lastName) {
        this.id = id;
        this.name = name;
        this.lastName=lastName;
    }

    public NameModel() {
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

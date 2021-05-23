package org.launchcode.habittracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;


@Entity
public class Habit {

    //creates a primary key
    @Id
    @GeneratedValue
    private int id;

//    @NotBlank
//    @Size(max=50, message = "Please enter shorter name")
    private String name;

    //empty protected constructor used by JPA to create new instance
    public Habit() {    }

    //constructor
    public Habit(String name) { this.name = name; }

    //getters & setters
    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    //Overides
    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return super.toString(); }
}

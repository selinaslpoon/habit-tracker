package org.launchcode.habittracker.models;

import com.sun.istack.NotNull;
import org.launchcode.habittracker.models.data.AbstractEntity;

import javax.persistence.Entity;


@Entity
public class Habit extends AbstractEntity {

//    @NotBlank
//    @Size(max=50, message = "Please enter shorter name")
    @NotNull
    private String name;

    //empty protected constructor used by JPA to create new instance
    public Habit() {    }

    //constructor
    public Habit(String name) {
        super();
        this.name = name;
    }

    //getters & setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    //Overides
    @Override
    public String toString() { return super.toString(); }
}

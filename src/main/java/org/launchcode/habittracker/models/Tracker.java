package org.launchcode.habittracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;


@Entity
public class Tracker {

    //creates a primary key
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Habit habit;
    private Date date;

    //empty protected constructor used by JPA to create new instance
    public Tracker() {    }

    //constructor
    public Tracker(Habit habit, Date date) {
        this.habit = habit;
        this.date = date;
    }

    //getters & setters
    public int getId() { return id; }

    public Habit getHabit() { return habit; }

    public void setHabit(Habit habit) { this.habit = habit; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    //Overides
    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return super.toString(); }
}

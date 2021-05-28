package org.launchcode.habittracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
//import javax.validation.constraints.Size;


@Entity
public class Tracker {

    //creates a primary key
    @Id
    @GeneratedValue
    private int id;

    private LocalDate date;

    @ManyToOne
    private Habit habit;

    //constructor
    public Tracker(LocalDate date, Habit habit) {
        this.date = date;
        this.habit = habit;
    }

    //empty protected constructor used by JPA to create new instance
    public Tracker() {    }

    //getters & setters
    public int getId() { return id; }

    public Habit getHabit() { return habit; }

    public void setHabit(Habit habit) { this.habit = habit; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    //Overides
    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return super.toString(); }
}

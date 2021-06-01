package org.launchcode.habittracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
//import javax.validation.constraints.Size;


@Entity
public class Tracker extends AbstractEntity {

    private LocalDate date;

    @ManyToOne
    private Habit habit;


    //empty protected constructor used by JPA to create new instance
    public Tracker() {    }

    //constructor
    public Tracker(LocalDate date, Habit habit) {
        super();
        this.date = date;
        this.habit = habit;
    }

    //getters & setters

    public Habit getHabit() { return habit; }

    public void setHabit(Habit habit) { this.habit = habit; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    //Overides
    @Override
    public String toString() { return super.toString(); }
}

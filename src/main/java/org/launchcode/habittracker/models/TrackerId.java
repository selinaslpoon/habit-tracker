package org.launchcode.habittracker.models;

import com.sun.istack.NotNull;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

//@Embeddable
public class TrackerId implements Serializable {

    @ManyToOne
    @NotNull
    private Habit habit;

   // @NotNull
    private LocalDate date;

    //constructor
    public TrackerId(Habit habit, LocalDate date) {
        this.habit = habit;
        this.date = date; //YYYY-MM-DD
    }

    //default constructor AKA empty constructor
    public TrackerId() { }

    //Getters and Setters
    public Habit getHabit() { return habit; }
    public void setHabit(Habit habit) { this.habit = habit; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    //Overrides


    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return super.toString(); }
}

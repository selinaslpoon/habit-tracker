package org.launchcode.habittracker.models;

import javax.persistence.*;
import java.time.LocalDate;

//Composite Primary Keys: https://www.baeldung.com/jpa-composite-primary-keys
//https://www.objectdb.com/java/jpa/entity/id#Composite_Primary_Key
//https://stackoverflow.com/questions/60622940/how-to-make-findby-with-composite-key-in-spring-data-jpa-hibernate-embedde

//Id class: https://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-jpa-and-hibernate
@Entity
@IdClass(TrackerId.class)
public class Tracker {
//    @EmbeddedId
//    private TrackerId trackerId;

    @ManyToOne
    @Id
    private Habit habit;

    @Id
    private LocalDate date;

    //  Default/empty constructor
    public Tracker() { }

    //constructor
    public Tracker(Habit habit, LocalDate date) {
        this.habit = habit;
        this.date = date; //YYYY-MM-DD
    }

    //getterd and setters
    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //    //Constructor
//    public Tracker(TrackerId trackerId) { this.trackerId = trackerId; }
//
//    //Getters and Setters
//    public TrackerId getCompleteHabitId() { return trackerId; }
//    public void setCompleteHabitId(TrackerId trackerId) { this.trackerId = trackerId; }

    //Overrides
    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return super.toString(); }
}








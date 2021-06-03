package org.launchcode.habittracker.controllers;

import org.launchcode.habittracker.models.Habit;
import org.launchcode.habittracker.models.Tracker;
import org.launchcode.habittracker.models.data.HabitRepository;
import org.launchcode.habittracker.models.data.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HabitRepository habitRepository;

    @Autowired
    TrackerRepository trackerRepository;

    static List<LocalDate> dates = new ArrayList<>();
    static LocalDate newDate = LocalDate.of(2021, 6, 1);
    static List<Habit> allHabits = new ArrayList<>();
//    static List<Boolean> isComplete = new ArrayList<>();
    static ArrayList<ArrayList<Boolean>> isComplete = new ArrayList<>();
    static Integer foundComplete;

    public HomeController() {

        //temporary list of dates
        //initialise date
        LocalDate newDate = LocalDate.of(2021, 6, 1);
        for (long i = 0; i < newDate.lengthOfMonth(); i++ ) {
            dates.add(newDate.plusDays(i));
        }
    }

    @GetMapping
    public String displayAllHabits(Model model) {

        //new instance of habit for add habit form
        model.addAttribute(new Habit());
        model.addAttribute(new Tracker());
        model.addAttribute("dates", dates);
        model.addAttribute("habits", habitRepository.findAll());



        //get data for checkboxes
        Iterable<Habit> allHabits = habitRepository.findAll();
        for (Habit habit : allHabits) {
            System.out.println(habit);
            ArrayList<Boolean> aHabit = new ArrayList<>();
             for (LocalDate date : dates) {
                 System.out.println(date);
                 foundComplete = 0;
                 System.out.println("reset to " + foundComplete);
                 Iterable<Tracker> allTracker = trackerRepository.findAll();
                 for (Tracker tracker : allTracker) {
                     System.out.println(tracker.getHabit().getName() + " and " + tracker.getDate());
                     System.out.println(tracker.getHabit().getId());
                     System.out.println(habit.getId());
                     System.out.println(tracker.getDate());
                     System.out.println(date);
                     if (tracker.getHabit().getId() == habit.getId() && tracker.getDate().compareTo(date) == 0) {
                         foundComplete = 1;
                         System.out.println("foundComplete set to : " + foundComplete);
                         break;
                     } else {
                         System.out.println("Could not find this habit and date in tracker");
                     }
                 }

                 if (foundComplete == 1) {
                     aHabit.add(true);
                     System.out.println("Has been set to true");
                 } else if (foundComplete == 0) {
                     aHabit.add(false);
                     System.out.println("Has been set to false");
                 }
             }
             System.out.println(aHabit);
             isComplete.add(aHabit);
            System.out.println(isComplete);
        }

        //get checkbox data
        model.addAttribute("isComplete", isComplete);

        return "index";
    }

    @PostMapping
    public String processAddHabit(@ModelAttribute Habit newHabit) {
        habitRepository.save(newHabit);
        return "redirect:";
    }

}

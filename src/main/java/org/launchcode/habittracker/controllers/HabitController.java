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
public class HabitController {

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

    public HabitController() {

        //temporary list of dates
        //initialise date
        LocalDate newDate = LocalDate.of(2021, 6, 1);
        for (long i = 0; i < newDate.lengthOfMonth(); i++ ) {
            dates.add(newDate.plusDays(i));
        }
    }

    @GetMapping("/habit")
    public String displayAllHabits(Model model) {

        //new instance of habit for add habit form
        model.addAttribute(new Habit());
        model.addAttribute(new Tracker());
        model.addAttribute("dates", dates);
        model.addAttribute("habits", habitRepository.findAll());

        return "/habit";
    }

    @GetMapping("/delete")
    public String displayHabitsToDelete(Model model) {

        //new instance of habit for add habit form
        model.addAttribute(new Habit());
        model.addAttribute(new Tracker());
        model.addAttribute("dates", dates);
        model.addAttribute("habits", habitRepository.findAll());

        return "/delete";
    }

//    @PostMapping("/habit")
//    public String processAddHabit(@ModelAttribute Habit newHabit) {
//        habitRepository.save(newHabit);
//        return "redirect:/habit";
//    }

    @PostMapping("/delete")
    public String processDeleteHabit(@ModelAttribute Habit newHabit) {
        System.out.println("New habit " + newHabit.getName());
        habitRepository.save(newHabit);
        return "redirect:/delete";
    }

}

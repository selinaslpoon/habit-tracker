package org.launchcode.habittracker.controllers;

import org.launchcode.habittracker.models.Habit;
import org.launchcode.habittracker.models.data.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("")
public class HomeController {

    @Autowired
    HabitRepository habitRepository;

    static List<String> habits = new ArrayList<>();
    static List<Integer> dates = new ArrayList<>();

    public HomeController() {
        //temporary list of dates
        for (int i = 1; i < 32; i++ ) {
            dates.add(i);
        }
    }

    @GetMapping
    public String displayAllHabits(Model model) {
//        Habit newHabit = new Habit("Walk dog");
//        habitRepository.save(newHabit);
        model.addAttribute(new Habit());
        model.addAttribute("dates", dates);
        model.addAttribute("habits", habitRepository.findAll());
        return "index";
    }

//    @GetMapping
//    public String addHabitForm(Model model) {
//        model.addAttribute(new Habit());
//        return "index";
//    }

    @PostMapping
    public String processAddHabit(@ModelAttribute Habit newHabit, Model model) {
//        model.addAttribute(new Habit());
        habitRepository.save(newHabit);
        return "redirect:";
    }



//    @RequestMapping(value="")
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping(value="goodbye")
//    @ResponseBody
//    public String goodbye(){
//        return "Goodbye";
//    }
}

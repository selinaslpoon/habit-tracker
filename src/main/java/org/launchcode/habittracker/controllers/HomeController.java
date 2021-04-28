package org.launchcode.habittracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static List<String> habits = new ArrayList<>();

    @GetMapping
    public String displayAllHabits(Model model) {
        model.addAttribute("habits", habits);
        return "index";
    }

    @PostMapping
    public String addHabit(@RequestParam String habitName) {
        habits.add(habitName);
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

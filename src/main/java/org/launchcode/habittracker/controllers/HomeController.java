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

//Toggle tokens: https://uxmovement.com/forms/why-toggle-tokens-are-a-better-alternative-to-checkboxes/
//https://getbootstrap.com/docs/4.1/components/buttons/
//https://www.codejava.net/frameworks/spring-boot/spring-thymeleaf-form-multi-checkboxes-mapping-with-collection-example

//LocalDate: https://www.geeksforgeeks.org/localdate-of-method-in-java-with-examples/
//CRUD repository methods: https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
//composite primary key example: https://www.callicoder.com/hibernate-spring-boot-jpa-composite-primary-key-example/

@Controller
//@RequestMapping("")
public class HomeController {


    @Autowired
    HabitRepository habitRepository;

    @Autowired
    TrackerRepository trackerRepository;

    static List<LocalDate> dates = new ArrayList<>();
    static LocalDate newDate = LocalDate.of(2021, 5, 1);

    public HomeController() {

        //temporary list of dates
        //initialise date
        LocalDate newDate = LocalDate.of(2021, 5, 1);
        for (long i = 0; i < newDate.lengthOfMonth(); i++ ) {
            dates.add(newDate.plusDays(i));
        }

//        Habit newHabit = new Habit("Test");
//        habitRepository.save(newHabit);
//        Tracker newTracker = new Tracker(newHabit, newDate);
//        trackerRepository.save(newTracker);

        //testing tracker repository
//
//        Habit testHabit = new Habit("Test2");
//        habitRepository.save(testHabit);
//
//        Habit aHabit = habitRepository.findById(testHabit.getId());

//        LocalDate testDate = LocalDate.of(2021, 5, 1);
//        Tracker testTracker = new Tracker(testHabit, testDate);
//        trackerRepository.save(testTracker);

    }

    @GetMapping
    public String displayAllHabits(Model model) {

//        //test for creating and saving new habits AND TRACKER
//        Habit newHabit = new Habit("second tracker test");
//        habitRepository.save(newHabit);
//        Tracker newTracker = new Tracker();
//        newTracker.setHabit(newHabit);
//        LocalDate testDate = LocalDate.of(2021, 5, 1);
//        newTracker.setDate(testDate);
//        trackerRepository.save(newTracker);


//        //delete tracker by ID
//        Optional<Tracker> delTracker = trackerRepository.findById(114);
//        if (!delTracker.isEmpty()) {
//            trackerRepository.deleteById(delTracker.get().getId());
//        }
//

//        //delete habit by ID
//        Optional<Habit> delHabit = habitRepository.findById(113);
//        if (!delHabit.isEmpty()) {
//            habitRepository.deleteById(delHabit.get().getId());
//        }


//        //find habit and delete tracker data - use when deleting a habit
//       Iterable<Habit> aHabit = habitRepository.findAll();
//       for (Habit eachHabit : aHabit) {
//           if(eachHabit.getName().equals("second tracker test")) {
//               Iterable<Tracker> aTracker = trackerRepository.findAll();
//               for (Tracker eachTracker : aTracker) {
//                   if(eachTracker.getHabit().getId() == (eachHabit.getId())) {
//                       trackerRepository.deleteById(eachTracker.getId());
//                   }
//               }
//           }
//       }


//        //test for finding a habit and saving new tracker - use for checkbox
////        Iterable<Habit> aHabit = habitRepository.findAll();
//       for (Habit eachHabit : aHabit) {
//           if(eachHabit.getName().equals("second tracker test")) {
//               Tracker newTracker = new Tracker();
//               LocalDate testDate = LocalDate.of(2021, 6, 1);
//               newTracker.setHabit(eachHabit);
//               newTracker.setDate(testDate);
//               trackerRepository.save(newTracker);
//           }
//       }



        //new instance of habit for add habit form
        model.addAttribute(new Habit());
        model.addAttribute(new Tracker());
        model.addAttribute("dates", dates);
        model.addAttribute("habits", habitRepository.findAll());

        //testing checkboxes: https://frontbackend.com/thymeleaf/how-to-add-checked-attribute-to-input-conditionally-in-thymeleaf
        model.addAttribute("flag", true);

        return "index";
    }

//    @GetMapping
//    public String addHabitForm(Model model) {
//        model.addAttribute(new Habit());
//        return "index";
//    }

    @PostMapping
    public String processAddHabit(@ModelAttribute Habit newHabit,  Model model) {
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

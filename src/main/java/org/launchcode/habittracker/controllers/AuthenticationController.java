package org.launchcode.habittracker.controllers;

import org.launchcode.habittracker.models.User;
import org.launchcode.habittracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    //This code allows us to store and retrieve the login status of a user in a session.
    // More specifically, a logged-in user’s user ID will be stored in their session.
    //eg session_id	81LfWG9, user	42

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey); //userSessionKey used to store user IDs
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }
    //setUserInSession used to store key/value pair
    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

}


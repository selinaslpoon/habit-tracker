package org.launchcode.habittracker;

import org.launchcode.habittracker.controllers.AuthenticationController;
import org.launchcode.habittracker.models.User;
import org.launchcode.habittracker.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    //creates a whitelist for any users
    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css");

    //check if whitelisted
    //If you wanted to be more restrictive, you could use .equals() instead of .startsWith().
    // If the path is whitelisted, we return true. Otherwise, we return false.
    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        // Don't require sign-in for whitelisted pages
        //request.getRequestURI() returns the request path
        if (isWhitelisted(request.getRequestURI())) {
            // returning true indicates that the request may proceed
            return true;
        }

        //Retrieves the user’s session object, which is contained in the request.
        HttpSession session = request.getSession();
        //Retrieves the User object corresponding to the given user.
        // Recall that this will be null if the user is not logged in.
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        // Allow the request to be handled as normal.
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        //redirect the user to the login page.
        response.sendRedirect("/login");
        return false;
    }


}

package com.loopme.servlet.auth;

import com.loopme.entity.Preferences;
import com.loopme.entity.User;
import com.loopme.persistence.UserDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signUpServlet extends HttpServlet {

    UserDao dbHelper;
    User user;
    Preferences preferences;
    List<User> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbHelper = new UserDao();
        user = new User();
        preferences = new Preferences();
        users = new ArrayList<User>();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("sign up");

        //Create new user
        user.setEmail(request.getParameter("email"));
        System.out.println("in servlet");
        user.setName(request.getParameter("name"));
        user.setPhotoUrl(request.getParameter("photoUrl"));
        user.setUid(request.getParameter("uid"));
        user.setRole("user");
        user.setHomeAddress(null);
        user.setHomeGPS(null);

        //Create default preferences
        preferences.setDistanceUnit("mi");
        preferences.setUseHomeAddress(false);
        user.setPreferences(preferences);

        //Add user to users and save
        users = dbHelper.getUsers();
        System.out.println("Users read:");
        for(User u : users){
            System.out.println(u.toString());
        }

        users.add(user);
        dbHelper.saveUsers(users);

        //Redirect to account
        request.getRequestDispatcher("/signIn?email="+request.getParameter("email")).forward(request, response);
    }

    @Override
    public void destroy() {}

}

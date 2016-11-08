package com.loopme.servlet.auth;

import com.loopme.entity.Preferences;
import com.loopme.entity.User;
import com.loopme.persistence.FireDBHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class signUpServlet extends HttpServlet {

    FireDBHelper dbHelper;
    User user;
    Preferences preferences;
    List<User> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbHelper = new FireDBHelper();
        user = new User();
        preferences = new Preferences();
        users = new ArrayList<User>();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Create new user
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setPhotoUrl(request.getParameter("photoUrl"));
        user.setUid(request.getParameter("uid"));

        user.setHomeAddress(null);
        user.setHomeGPS(null);

        //Create default preferences
        preferences.setDistanceUnit("mi");
        preferences.setUseHomeAddress(false);
        user.setPreferences(preferences);

        //Add user to users and save
        users = dbHelper.getUsers();
        users.add(user);
        dbHelper.saveUsers(users);

        //Set user in session
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        //Redirect to account
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }

    @Override
    public void destroy() {}

}

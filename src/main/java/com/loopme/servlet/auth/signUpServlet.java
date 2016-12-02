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
import javax.servlet.http.HttpSession;

public class signUpServlet extends HttpServlet {

    UserDao userDao;
    User user;
    Preferences preferences;
    List<User> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        user = new User();
        preferences = new Preferences();
        users = new ArrayList<User>();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Setup new userDao if it doesn't exist
        HttpSession session = request.getSession(true);
        if(session.getAttribute("userDao")==null){
            UserDao userDao = new UserDao();
            session.setAttribute("userDao",userDao);
        }

        userDao = (UserDao) session.getAttribute("userDao");

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
        userDao.addUser(user);
        userDao.saveUsers();

        //Release userDao from session to reload list of users in userDao
        session.removeAttribute("userDao");

        //Redirect to account
        request.getRequestDispatcher("/signIn?email="+request.getParameter("email")).forward(request, response);
    }

    @Override
    public void destroy() {}

}

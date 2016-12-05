package com.excerloops.servlet.persistence;

import com.excerloops.entity.Preferences;
import com.excerloops.entity.User;
import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class updatePreferencesServlet extends HttpServlet {

    UserDao userDao;
    User user;
    Preferences preferences;
    HttpSession session;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get session and Dao
        session = request.getSession(true);
        userDao = (UserDao) session.getAttribute("userDao");

        //Get user based on email (id)
        user = (User) session.getAttribute("user");
        preferences = user.getPreferences();

        //Update preferences
        preferences.setDefaultHomeEnabled(Boolean.parseBoolean(request.getParameter("homeEnabled")));
        preferences.setDefaultHome(request.getParameter("home"));
        preferences.setDefaultUnitEnabled(Boolean.parseBoolean(request.getParameter("unitEnabled")));
        preferences.setDefaultUnit(request.getParameter("unit"));
        preferences.setLineColor(Integer.parseInt(request.getParameter("lineColor")));
        preferences.setTransitMode(request.getParameter("transitMode"));
        preferences.setNumberOfMarkers(Integer.parseInt(request.getParameter("numMarkers")));


        //Update Firebase
        user.setPreferences(preferences);
        userDao.updateUser(user);

        //Update session
        session.setAttribute("user", user);

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}

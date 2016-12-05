package com.excerloops.servlet.persistence;

import com.excerloops.entity.User;
import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class updateUserServlet extends HttpServlet {

    UserDao userDao;
    User user;
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
        user = userDao.readUser(request.getParameter("uid"));
        System.out.println(user.toString());

        //Update user
        user.setName(request.getParameter("name"));
        user.setPhotoUrl(request.getParameter("photoUrl"));
        user.setRole(request.getParameter("role"));
        //user.setHomeAddress(request.getParameter("address"));
        //user.setHomeGPS(request.getParameter("gps"));

        userDao.updateUser(user);

        //Redirect to account
        response.sendRedirect("/users");

    }

    @Override
    public void destroy() {}

}

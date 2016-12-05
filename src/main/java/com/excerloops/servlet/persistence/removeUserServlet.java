package com.excerloops.servlet.persistence;

import com.excerloops.entity.User;
import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class removeUserServlet extends HttpServlet {

    UserDao userDao;
    User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = new UserDao();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get user based on email (id)
        userDao.deleteUser(request.getParameter("uid"));

        //Set user in session
        //HttpSession session = request.getSession(true);
        //session.setAttribute("user", user);

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}
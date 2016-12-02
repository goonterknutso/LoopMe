package com.loopme.servlet.admin;

import com.loopme.entity.User;
import com.loopme.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class removeUserServlet extends HttpServlet {

    UserDao dbHelper;
    User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbHelper = new UserDao();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get user based on email (id)
        user = dbHelper.getUser(request.getParameter("email"));
        System.out.println(user.toString());

        //Set user in session
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}
package com.excerloops.servlet.persistence.user;

import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteUserServlet extends HttpServlet {

    UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("DELETE USER SERVLET");

        //Setup new userDao if it doesn't exist
        HttpSession session = request.getSession(true);
        if(session.getAttribute("userDao")==null){
            UserDao userDao = new UserDao();
            session.setAttribute("userDao",userDao);
        }

        userDao = (UserDao) session.getAttribute("userDao");

        //Delete user with passed in uid
        userDao.deleteUser(request.getParameter("uid"));

        //Set user in session
        session.setAttribute("user", null);

        //Redirect to account
        response.sendRedirect("/signIn");
    }

    @Override
    public void destroy() {}

}
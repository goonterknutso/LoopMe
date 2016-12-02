package com.loopme.servlet.auth;

import com.loopme.entity.User;
import com.loopme.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class signInServlet extends HttpServlet {

    UserDao userDao;
    User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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

        //Get user based on email (id)
        userDao = (UserDao) session.getAttribute("userDao");
        user = userDao.getUser(request.getParameter("email"));
        System.out.println(user.toString());

        //Set user in session
        session.setAttribute("user", user);

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}

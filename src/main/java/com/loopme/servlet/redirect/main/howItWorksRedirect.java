package com.loopme.servlet.redirect.main;

import com.loopme.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class howItWorksRedirect extends HttpServlet {
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

        //Redirect
        request.getRequestDispatcher("how_it_works.jsp").forward(request, response);
    }
    @Override
    public void destroy() {
    }
}
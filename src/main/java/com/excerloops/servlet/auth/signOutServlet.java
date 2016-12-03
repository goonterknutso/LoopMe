package com.excerloops.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class signOutServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get session
        HttpSession session = request.getSession(true);

        //Remove user
        session.setAttribute("user", null);
        System.out.println("signed out");
        //Redirect to sign in
        response.sendRedirect("/signIn");
    }

    @Override
    public void destroy() {}

}


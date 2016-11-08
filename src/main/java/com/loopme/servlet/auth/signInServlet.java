package com.loopme.servlet.auth;

import com.loopme.entity.User;
import com.loopme.persistence.FireDBHelper;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class signInServlet extends HttpServlet {

    FireDBHelper dbHelper;
    User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbHelper = new FireDBHelper();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get user based on email (id)
        user = dbHelper.getUser(request.getParameter("email"));

        //Set user in session
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

    }

    @Override
    public void destroy() {}

}

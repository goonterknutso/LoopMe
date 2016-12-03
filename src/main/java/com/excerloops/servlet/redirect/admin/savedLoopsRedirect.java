package com.excerloops.servlet.redirect.admin;

import com.excerloops.entity.User;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class savedLoopsRedirect extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get session
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        //Only allow admin to get to users.jsp
        if(user != null && user.getRole().equals("admin")){
            request.getRequestDispatcher("admin/saved_loops.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("account.jsp").forward(request, response);
        }
    }
    @Override
    public void destroy() {
    }
}
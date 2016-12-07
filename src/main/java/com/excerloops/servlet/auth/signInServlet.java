package com.excerloops.servlet.auth;

import com.excerloops.entity.SavedLoop;
import com.excerloops.entity.User;
import com.excerloops.persistence.SavedLoopsDao;
import com.excerloops.persistence.UserDao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class signInServlet extends HttpServlet {

    UserDao userDao;
    SavedLoopsDao savedLoopsDao;
    User user;
    ArrayList<SavedLoop> savedLoops;

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
            userDao = new UserDao();
            session.setAttribute("userDao",userDao);
        }
        if(session.getAttribute("savedLoopsDao")==null){
            savedLoopsDao = new SavedLoopsDao();
            session.setAttribute("savedLoopsDao",savedLoopsDao);
        }

        //Get user based on uid, set session
        userDao = (UserDao) session.getAttribute("userDao");
        user = userDao.readUser(request.getParameter("uid"));
        session.setAttribute("user", user);

        //Get saved loops, set session
        savedLoopsDao = (SavedLoopsDao) session.getAttribute("savedLoopsDao");
        savedLoops = savedLoopsDao.readAllSavedLoops(request.getParameter("uid"));
        session.setAttribute("savedLoops", savedLoops);

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}

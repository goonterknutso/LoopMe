package com.excerloops.servlet.auth;

import com.excerloops.entity.Preferences;
import com.excerloops.entity.User;
import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class createUserServlet extends HttpServlet {

    UserDao userDao;
    User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        user = new User();
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

        userDao = (UserDao) session.getAttribute("userDao");

        //Check if Google Sign In
        if(request.getParameter("googleSignIn").equals("true")){
            System.out.println("Google Sign In");
            request.removeAttribute("googleSignIn");
            //User exists, sign in user
            if(userDao.checkExist(request.getParameter("uid"))){
                System.out.println("GETTING IN HERE!!!!");
                request.getRequestDispatcher("/signIn?uid="+request.getParameter("uid")).forward(request, response);
                return;
            }
        }

        //Create new user
        System.out.println("CREATE USER");
        user.setName(request.getParameter("name"));
        user.setPhotoUrl(request.getParameter("photoUrl").toString());
        user.setEmail(request.getParameter("email"));
        user.setUid(request.getParameter("uid"));
        user.setRole("user");
        user.setPreferences(new Preferences());
        user.setSavedLoops(null);

        //Add user to users and save
        userDao.createUser(user);

        //Release userDao from session to reload list of users in userDao
        session.removeAttribute("userDao");

        //Redirect to account
        request.getRequestDispatcher("/signIn?uid="+request.getParameter("uid")).forward(request, response);
    }

    @Override
    public void destroy() {}

}

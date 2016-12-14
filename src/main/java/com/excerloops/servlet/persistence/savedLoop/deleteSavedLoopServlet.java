package com.excerloops.servlet.persistence.savedLoop;

import com.excerloops.entity.SavedLoop;
import com.excerloops.entity.User;
import com.excerloops.persistence.SavedLoopsDao;
import com.excerloops.persistence.UserDao;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteSavedLoopServlet extends HttpServlet {

    SavedLoopsDao savedLoopsDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Setup new savedLoopsDao
        HttpSession session = request.getSession(true);
        if(session.getAttribute("savedLoopsDao")==null){
            savedLoopsDao = new SavedLoopsDao();
            session.setAttribute("savedLoopsDao", savedLoopsDao);
        }

        //Get Saved Loops Dao
        savedLoopsDao = (SavedLoopsDao) session.getAttribute("savedLoopsDao");

        //Read in Parameters
        String id = request.getParameter("id");
        String uid = request.getParameter("uid");

        //Read loop from database
        if(savedLoopsDao.deleteSavedLoop(id, uid)){
            session.setAttribute("savedLoopDeleted",true);
        } else {
            session.setAttribute("savedLoopDeleted",false);
        }

        //Update saved loops in session
        session.setAttribute("savedLoops", savedLoopsDao.readAllSavedLoops(uid));

        //Redirect to account
        response.sendRedirect("/account");

    }

    @Override
    public void destroy() {}

}
package com.excerloops.servlet.persistence.savedLoop;

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

public class addSavedLoopServlet extends HttpServlet {

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

        ArrayList<Double> lats = new ArrayList<Double>();
        ArrayList<Double> lngs = new ArrayList<Double>();

        //Read in Parameters
        String name = request.getParameter("name");
        String startAddress = request.getParameter("startAddress");
        double startLat = Double.parseDouble(request.getParameter("startLat"));
        double startLng = Double.parseDouble(request.getParameter("startLng"));
        double inputDistance = Double.parseDouble(request.getParameter("inputDistance"));
        double distanceKM = Double.parseDouble(request.getParameter("distanceKM"));
        double distanceMI = Double.parseDouble(request.getParameter("distanceMI"));
        String unit = request.getParameter("unit");
        String transitMode = request.getParameter("transitMode");
        int zoom = Integer.parseInt(request.getParameter("zoom"));

        String uid = request.getParameter("uid");

        //Read in lat and lng coords as string array and convert
        String[] resultsLat = request.getParameter("resultsLat").split(",");
        String[] resultsLng = request.getParameter("resultsLng").split(",");

        for(String s : resultsLat){
            lats.add(Double.parseDouble(s));
        }
        for(String s : resultsLng){
            lngs.add(Double.parseDouble(s));
        }

        //Create new saved loop object
        SavedLoop newSavedLoop = new SavedLoop();

        //Set SavedLoop variables
        newSavedLoop.setName(name);
        newSavedLoop.setStartAddress(startAddress);
        newSavedLoop.setStartLat(startLat);
        newSavedLoop.setStartLng(startLng);
        newSavedLoop.setInputDistance(inputDistance);
        newSavedLoop.setDistanceKM(distanceKM);
        newSavedLoop.setDistanceMI(distanceMI);
        newSavedLoop.setUnit(unit);
        newSavedLoop.setTransitMode(transitMode);
        newSavedLoop.setZoom(zoom);
        newSavedLoop.setResultsLat(lats);
        newSavedLoop.setResultsLng(lngs);

        //Add saved loop to database
        if(savedLoopsDao.addSavedLoop(newSavedLoop, uid)){
            session.setAttribute("loopAdded", true);
            //Update session attribute for all saved loops
            session.setAttribute("savedLoops", savedLoopsDao.readAllSavedLoops(uid));
        } else {
            session.setAttribute("loopAdded", false);
        }



        //Redirect to back to previous page
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

    }

    @Override
    public void destroy() {}

}

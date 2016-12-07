package com.excerloops.servlet.generate;

import com.excerloops.entity.SavedLoop;
import com.excerloops.entity.User;
import com.excerloops.interfaces.ExcerloopsInterface;
import com.excerloops.loopGenerator.Loops;
import com.excerloops.persistence.SavedLoopsDao;
import com.excerloops.persistence.UserDao;
import com.excerloops.util.GoogleAPIUtil;
import com.excerloops.util.LoopConverter;
import com.excerloops.util.LoopFileReader;
import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class viewSavedLoopServlet extends HttpServlet implements ExcerloopsInterface {

    SavedLoopsDao savedLoopsDao;
    SavedLoop savedLoop;

    User user;
    LatLng startLatLng;
    String unit;
    Double distance;
    String address;
    ArrayList<LatLng> waypoints;
    ArrayList<LatLng> markers;
    int zoom;

    int numMarkers;
    int lineColor;
    String transitMode;
    String uri;

    String url;

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

        //Get parameters
        String id = request.getParameter("id");
        String uid = request.getParameter("uid");


        //Read in Loop from database
        savedLoop = savedLoopsDao.readSavedLoop(id, uid);
        address = savedLoop.getStartAddress();
        startLatLng = new LatLng(savedLoop.getStartLat(), savedLoop.getStartLng());
        distance = savedLoop.getInputDistance();
        unit = savedLoop.getUnit();

        zoom = savedLoop.getZoom();
        transitMode = savedLoop.getTransitMode();

        waypoints = new ArrayList<LatLng>();
        for(int i = 0; i<savedLoop.getResultsLat().size(); i++){
            waypoints.add(new LatLng(savedLoop.getResultsLat().get(i),savedLoop.getResultsLng().get(i)));
        }
        uri = GoogleAPIUtil.getMapsIntentUri(startLatLng, waypoints, transitMode);


        //Set user preferences or default
        user = (User) session.getAttribute("user");
        if(user != null) {
            if (waypoints.size() <= user.getPreferences().getNumberOfMarkers()) {
                numMarkers = waypoints.size();
            } else {
                numMarkers = user.getPreferences().getNumberOfMarkers();
            }
            lineColor = user.getPreferences().getLineColor();
        } else {
            numMarkers = 5;
            lineColor = BLUE;
        }
        markers = GoogleAPIUtil.getRouteMarkers(waypoints, numMarkers);
        uri = GoogleAPIUtil.getMapsIntentUri(startLatLng, waypoints, transitMode);

        //Set request attributes
        request.setAttribute("id", savedLoop.getId());
        request.setAttribute("address", address);
        request.setAttribute("startLatLng", startLatLng);
        request.setAttribute("distance", distance);
        request.setAttribute("distKM", savedLoop.getDistanceKM());
        request.setAttribute("distMI", savedLoop.getDistanceMI());
        request.setAttribute("unit", unit);
        request.setAttribute("waypoints", waypoints);
        request.setAttribute("numMarkers", numMarkers);
        request.setAttribute("markers", markers);
        request.setAttribute("zoom", zoom);
        request.setAttribute("transitMode", transitMode);
        request.setAttribute("lineColor", lineColor);
        request.setAttribute("mapsUri", uri);

        //Redirect to generatedMap
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewLoopRedirect");
        rd.forward(request, response);
    }

    @Override
    public void destroy() {}

}

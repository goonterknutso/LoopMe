package com.excerloops.servlet.generate;

import com.excerloops.entity.User;
import com.excerloops.interfaces.ExcerloopsInterface;
import com.excerloops.loopGenerator.Loops;
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

public class createMapServlet extends HttpServlet implements ExcerloopsInterface{

    User user;
    LatLng startLatLng;
    String unit;
    Double distance;
    LoopFileReader loopFileReader;
    LoopConverter loopConverter;
    Loops loops;
    Double lat;
    Double lng;
    String address;
    LatLng[] waypoints;
    double distanceGenerated;
    double distanceGeneratedKM;
    double distanceGeneratedMI;

    ArrayList<LatLng> converted;
    ArrayList<LatLng> markers;

    String apiResponse;
    ArrayList<LatLng> apiResults;
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

        HttpSession session = request.getSession(true);

        System.out.println("IN!!!");

        //Read in parameters from index
        address = request.getParameter("address");
        lat = Double.parseDouble(request.getParameter("lat"));
        lng = Double.parseDouble(request.getParameter("lng"));
        startLatLng = new LatLng(lat, lng);
        distance = Double.parseDouble(request.getParameter("distance"));
        unit = request.getParameter("unit");

        url = "/createMap?address="+address+
                "&lat="+lat+
                "&lng="+lng+
                "&distance="+distance+
                "&unit="+unit;

        //Create necessary objects
        loopFileReader = new LoopFileReader();
        loopConverter = new LoopConverter(startLatLng, distance, unit);
        loops = loopFileReader.readLoopsFromFile();
        waypoints = loopConverter.convertRandomLoop(loops);

        //Converts waypoints from LatLng[] to ArrayList<LatLng>
        converted = new ArrayList<LatLng>();
        converted.add(startLatLng);
        for(LatLng l : waypoints){
            converted.add(new LatLng(l.lat, l.lng));
        }

        //Make first call to Google Maps Directions API
        String initResponse = GoogleAPIUtil.getDirectionsAPIResponse(startLatLng, converted);
        ArrayList<LatLng> initResults = GoogleAPIUtil.parseOverviewPolyLine(initResponse);

        //Make second call
        apiResponse = GoogleAPIUtil.getDirectionsAPIResponse(startLatLng, GoogleAPIUtil.trimResults(GoogleAPIUtil.removeDoubleBacks(initResults, true)));
        apiResults = GoogleAPIUtil.trimResults(GoogleAPIUtil.parseOverviewPolyLine(apiResponse));

        System.out.println(response);

        //Set distances
        distanceGenerated = GoogleAPIUtil.parseDistance(apiResponse);
        distanceGeneratedMI = (0.000621371*distanceGenerated);
        distanceGeneratedKM = distanceGenerated/1000;

        //Set user preferences or default

        user = (User) session.getAttribute("user");
        if(user != null) {
            if (apiResults.size() <= user.getPreferences().getNumberOfMarkers()) {
                numMarkers = apiResults.size();
            } else {
                numMarkers = user.getPreferences().getNumberOfMarkers();
            }
            transitMode = user.getPreferences().getTransitMode();
            lineColor = user.getPreferences().getLineColor();
        } else {
            numMarkers = 5;
            transitMode = RUN;
            lineColor = BLUE;
        }
        markers = GoogleAPIUtil.getRouteMarkers(apiResults, numMarkers);

        //Set zoom
        zoom = GoogleAPIUtil.radiusToZoom(distance)+1;
        uri = GoogleAPIUtil.getMapsIntentUri(startLatLng, apiResults, transitMode);

        //Set request attributes
        request.setAttribute("address", address);
        request.setAttribute("startLatLng", startLatLng);
        request.setAttribute("distance", distance);
        request.setAttribute("unit", unit);

        request.setAttribute("waypoints", apiResults);
        request.setAttribute("distanceGeneratedMI", distanceGeneratedMI);
        request.setAttribute("distanceGeneratedKM", distanceGeneratedKM);
        request.setAttribute("numMarkers", numMarkers);
        request.setAttribute("markers", markers);
        request.setAttribute("zoom", zoom);
        request.setAttribute("transitMode", transitMode);
        request.setAttribute("lineColor", lineColor);
        request.setAttribute("mapsUri", uri);
        request.setAttribute("url", url);

        //Redirect to generatedMap
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/generatedMap");
        rd.forward(request, response);
    }

    @Override
    public void destroy() {
        getServletContext().log("destroy() called");
    }

}

package com.excerloops.util;

import com.excerloops.interfaces.ExcerloopsInterface;
import com.excerloops.persistence.UserDao;
import com.google.maps.model.LatLng;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
/**
 * Created by student on 11/16/2016.
 */

public class GoogleAPIUtil implements ExcerloopsInterface {

    static Logger log = Logger.getLogger(UserDao.class.getName());

    public static String getDirectionsAPIResponse(LatLng start, ArrayList<LatLng> waypoints){
        try {
            String urlStr = "https://maps.googleapis.com/maps/api/directions/json";
            urlStr += "?origin="+start.lat+","+start.lng;
            urlStr += "&destination="+start.lat+","+start.lng;
            urlStr += "&waypoints=";

            for(int i = 0; i<waypoints.size(); i++){
                urlStr += /*"via:"+*/waypoints.get(i).lat+","+waypoints.get(i).lng;
                if(i != waypoints.size() -1){
                    urlStr += "|";
                }
            }
            urlStr += "&mode=walking";
            urlStr += "&key=AIzaSyB6GLTECvlfDuCR9HCVRN5xKmm0ca3RHV0";


            URL url = new URL(urlStr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    public static String getMapsIntentUri(LatLng start, ArrayList<LatLng> waypoints, String transitMode){
        String urlStr = "https://www.google.com/maps/dir/";
        urlStr += start.lat+","+start.lng+"/";
        for(int i = 0; i<waypoints.size(); i++){
            urlStr += waypoints.get(i).lat+","+waypoints.get(i).lng+"/";
        }
        urlStr += start.lat+","+start.lng;

        if(transitMode.equals(RUN)) {
            urlStr += "/data=!4m2!4m1!3e2";
        } else if(transitMode.equals(BIKE)) {
            urlStr += "/data=!4m2!4m1!3e1";
        } else if(transitMode.equals(DRIVE)) {
            urlStr+="/data=!4m2!4m1!3e0";
        } else {
            urlStr+="/data=!4m2!4m1!3e2";
        }
        return urlStr;
    }

    //Returns in meters
    public static double parseDistance(String json){
        //GeoCodedWaypoints->Routes->Legs-> foreach(Step s : Steps) ->PolyLine->points
        ArrayList<LatLng> points = new ArrayList<LatLng>();
        double distance = 0.0;

        try {
            //Read points from JSON
            JSONObject root = new JSONObject(json);
            JSONArray routesArray = root.getJSONArray("routes");
            JSONObject route = routesArray.getJSONObject(0);
            JSONArray legs = route.getJSONArray("legs");
            JSONObject leg;

            for(int i = 0; i<legs.length(); i++){
                int legDistance = legs.getJSONObject(i).getJSONObject("distance").getInt("value");
                distance += legDistance;
            }

            return distance;

        } catch (JSONException e){
            e.printStackTrace();
        }

        return distance;
    }

    public static ArrayList<LatLng> parseOverviewPolyLine(String json){
        //GeoCodedWaypoints->Routes->Legs-> foreach(Step s : Steps) ->PolyLine->points
        ArrayList<LatLng> points = new ArrayList<LatLng>();
        try {
            //Read points from JSON
            JSONObject root = new JSONObject(json);
            JSONArray routesArray = root.getJSONArray("routes");
            JSONObject route = routesArray.getJSONObject(0);
            JSONObject overviewPolyLine = route.getJSONObject("overview_polyline");
            String encodedPoints = overviewPolyLine.getString("points");

            points = decodePoly(encodedPoints);

            return points;

        } catch (JSONException e){
            e.printStackTrace();
        }

        return points;
    }

    public static ArrayList<LatLng> getRouteMarkers(ArrayList<LatLng> routeCoordinates, int
            numMarkers){
        ArrayList<LatLng> markers = new ArrayList<LatLng>();

        int modValue = routeCoordinates.size()/numMarkers;

        for(int i = 1; i<routeCoordinates.size(); i++){
            if(i%modValue == 0){
                markers.add(routeCoordinates.get(i));
            }
            if(markers.size()==numMarkers-1){
                return markers;
            }
        }
        return markers;
    }

    private static ArrayList<LatLng> decodePoly(String encoded) {

        //Log.i("Location", "String received: "+encoded);
        ArrayList<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),(((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    public static ArrayList<LatLng> removeDoubleBacks(ArrayList<LatLng> results, Boolean returnVal){

        //Array to store duplicates
        ArrayList<LatLng> duplicates = new ArrayList<LatLng>();
        ArrayList<LatLng> noDuplicates = new ArrayList<LatLng>();

        for(int i = 0; i<results.size(); i++){
            LatLng latLng = results.get(i);

            if(noDuplicates.contains(latLng)){
                duplicates.add(latLng);
            } else {
                noDuplicates.add(latLng);
            }
        }

        if(returnVal){
            return noDuplicates;
        } else {
            return duplicates;
        }

    }

    public static ArrayList<LatLng> trimResults(ArrayList<LatLng> results){
        ArrayList<LatLng> trimmedArray = new ArrayList<LatLng>();

        int modValue;

        //Calculate mod value based on size, returned array size needs to be 20 or less
        int size = results.size();
        if(size <= 20){
            modValue = 1;
        } else if(20 < size && size <= 40) {
            modValue = 2;
        } else {
            modValue = (size/20)+1;
        }

        for(int i = 0; i<results.size(); i++){
            if(i%modValue == 0){
                trimmedArray.add(results.get(i));
            }
        }
        return trimmedArray;
    }

    public static int radiusToZoom(double radius){
        return (int) Math.round(14-Math.log(radius)/Math.log(2));
    }

}

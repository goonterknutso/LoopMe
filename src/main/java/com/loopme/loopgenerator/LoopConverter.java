package com.loopme.loopgenerator;

import com.google.maps.GeoApiContext;
import com.google.maps.RoadsApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gunther on 10/12/16.
 */
public class LoopConverter {

    LatLng startingLocation;
    double distance;

    public LoopConverter(LatLng startingLocation, double distance){
        this.startingLocation = startingLocation;
        this.distance = distance;
    }

    public SnappedPoint[] snapPointsToRoad(Loop loop){
        GeoApiContext context = new GeoApiContext();
        context.setApiKey(System.getenv("API_KEY"));
        SnappedPoint[] snappedPoints = new SnappedPoint[loop.getCoordinates().size()];
        try {
            snappedPoints = RoadsApi.snapToRoads(context,
                    false,
                    convertLoop(loop)).await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return snappedPoints;

    }

    /**
     * Converts Coordinates for a Loop into a LatLng array of LatLng
     * @param loop
     * @return path
     */
    public LatLng[] convertLoop(Loop loop){

        LatLng[] path = new LatLng[loop.getCoordinates().size()];
        double legDistance = distance*((double)loop.getLegLength()/(double)loop.getRouteDistance());

        System.out.println(legDistance);

        double legLengthGPS = calculateLegDistanceKm(legDistance);

        for(int c = 0; c < loop.getCoordinates().size(); c++){

            //First or last coordinate pair (starting location)
            if(c == 0 || c == loop.getCoordinates().size()){
                path[c] = startingLocation;
            }

            path[c] = convertToLatLong(loop.getCoordinate(c), loop.getCoordinates(), legLengthGPS);

        }

        return path;
    }

    public LatLng convertToLatLong(Coordinate coordinate, List<Coordinate> coordinates, double legLengthGPS){
        Coordinate start = coordinates.get(0);
        LatLng latLng = new LatLng(0.0,0.0);


        latLng.lng = startingLocation.lng + ((coordinate.getX()-start.getX())*legLengthGPS);
        latLng.lat = startingLocation.lat + ((coordinate.getY()-start.getY())*legLengthGPS);

        return latLng;
    }

    public double calculateLegDistanceKm(double legLength){

        double R =  6372.8; // kilometres
        LatLng endingLocation = new LatLng(startingLocation.lat, startingLocation.lng);
        Double deltaGPS = 0.001534;

        double lat1 = startingLocation.lat;
        double lat2 = endingLocation.lat;
        double lon1 = startingLocation.lng;
        double lon2 = endingLocation.lng;

        //Loop until GPS distance is close to legLength
        while(true) {
            lon2 += deltaGPS;

            //Haversine Formula: Calculates distance between two GPS coordinates
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            lat1 = Math.toRadians(lat1);
            lat2 = Math.toRadians(lat2);

            double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
            double c = 2 * Math.asin(Math.sqrt(a));
            double d = R * c;

            //If were within 1% of the leglength either direction return delta GPS
            if((legLength - (legLength*.01)) < d && d < (legLength + (legLength*.01))){
                return (lon2 - lon1);
            }

            //If past the leglength, reset to previous lon2 and half the deltaGPS value
            if(d > (legLength + (legLength*.01))){
                lon2 -= deltaGPS;
                deltaGPS /= 2;
            }
        }
    }

}

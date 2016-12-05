package com.excerloops.util;


import com.excerloops.interfaces.ExcerloopsInterface;
import com.excerloops.loopGenerator.Coordinate;
import com.excerloops.loopGenerator.Loop;
import com.excerloops.loopGenerator.Loops;
import com.google.maps.model.LatLng;

import java.util.List;

/**
 * Created by gunther on 10/12/16.
 */
public class LoopConverter implements ExcerloopsInterface {

    LatLng startingLocation;
    double distance;
    String distanceUnit;


    public LoopConverter(LatLng startingLocation, double distance, String distanceUnit) {
        this.startingLocation = startingLocation;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
    }

    public LatLng[] convertRandomLoop(Loops loops){
        int random;

        random = (int) (Math.random() * loops.getLoops().size());
        return convertLoop(loops.getLoop(random));
    }

    /*
    public String[] getWaypoints(Loop loop){

        LatLng[] GPSCoordinates = convertLoop(loop);

        String[] allWaypoints = new String[GPSCoordinates.length];
        String[] waypoints = new String[GPSCoordinates.length - 2];

        //Converts GPSCoordinates from LatLng[] into String[]
        for(int i = 0; i<GPSCoordinates.length; i++){
           allWaypoints[i] = GPSCoordinates[i].toString();
        }

        //Remove starting and ending waypoints
        for(int i = 1; i < allWaypoints.length - 1; i++) {
            waypoints[i-1] = allWaypoints[i];
        }

        return waypoints;
    }
    */

    /**
     * Converts Coordinates for a com.excerloops.entity.Loop into a LatLng array of LatLng
     * @param loop
     * @return path
     */
    public LatLng[] convertLoop(Loop loop){

        LatLng[] path = new LatLng[loop.getCoordinates().size()];
        double legLengthGPS;
        double legDistance = (distance*((double)loop.getLegLength()/(double)loop.getRouteDistance
                ()));
        System.out.println("WTF!"+loop.getLegLength());

        if(distanceUnit.equals(KM)) {
            legLengthGPS = calculateLegDistanceKm(legDistance);
        } else {
            legLengthGPS = calculateLegDistanceMi(legDistance);
        }

        for(int c = 0; c < loop.getCoordinates().size(); c++){
            //First or last coordinate pair (starting location)
            if(c == 0 || c == loop.getCoordinates().size()){
                path[c] = startingLocation;
            }
            path[c] = convertToLatLong(loop.getCoordinate(c), loop, legLengthGPS);
        }

        return path;
    }

    public LatLng convertToLatLong(Coordinate coordinate, Loop loop, double legLengthGPS){
        List<Coordinate> coordinates = loop.getCoordinates();
        Coordinate start = coordinates.get(0);
        LatLng latLng = new LatLng(0.0,0.0);

        latLng = new LatLng(
                startingLocation.lat + ((coordinate.getX()-start.getX())/loop
                        .getLegLength()
                        *legLengthGPS) ,
                startingLocation.lng + ((coordinate.getY()-start.getY())/loop
                        .getLegLength()
                        *legLengthGPS));

        return latLng;
    }

    public double calculateLegDistanceMi(double legLength){
        System.out.println("in caluclate distance mi legLength = "+legLength);

        double R =  3959.87433; // miles
        LatLng endingLocation = new LatLng(startingLocation.lat, startingLocation.lng);
        double deltaGPS = 0.001534;

        double lat1 = startingLocation.lat;
        double lat2 = endingLocation.lat;
        double lon1 = startingLocation.lng;
        double lon2 = endingLocation.lng;

        //com.excerloops.entity.Loop until GPS distance is close to legLength
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
                deltaGPS /= 2.0;
            }
        }
    }

    public double calculateLegDistanceKm(double legLength){

        double R =  6372.8; // kilometres
        LatLng endingLocation = new LatLng(startingLocation.lat, startingLocation.lng);
        double deltaGPS = 0.001534;

        double lat1 = startingLocation.lat;
        double lat2 = endingLocation.lat;
        double lon1 = startingLocation.lng;
        double lon2 = endingLocation.lng;

        //com.excerloops.entity.Loop until GPS distance is close to legLength
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
                deltaGPS /= 2.0;
            }
        }
    }

}

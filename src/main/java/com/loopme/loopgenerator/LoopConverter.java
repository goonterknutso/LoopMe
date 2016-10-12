package com.loopme.loopgenerator;

import com.google.maps.GeoApiContext;
import com.google.maps.RoadsApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;

import java.util.concurrent.TimeUnit;

/**
 * Created by gunther on 10/12/16.
 */
public class LoopConverter {

    LatLng startingLocation;

    public LoopConverter(LatLng startingLocation){
        this.startingLocation = startingLocation;
    }

    public SnappedPoint[] snapPointsToRoad(){
        GeoApiContext context = new GeoApiContext();
        SnappedPoint[] snappedPoints = new SnappedPoint[2];
        try {
            snappedPoints = RoadsApi.snapToRoads(context,
                    false,
                    new LatLng(-33.865382, 151.192861),
                    new LatLng(-33.865837, 151.193376),
                    new LatLng(-33.866745, 151.19373),
                    new LatLng(-33.867128, 151.19344),
                    new LatLng(-33.867547, 151.193676),
                    new LatLng(-33.867841, 151.194137),
                    new LatLng(-33.868224, 151.194116)).await();
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

        for(int c = 0; c < loop.getCoordinates().size(); c++){
            //path[c] = convertToLatLong(loop.getCoordinate(c));
        }

        return path;
    }

    /*public LatLng convertToLatLong(Coordinate coordinate){

    }*/


    public double calculateLegDistanceKm(int legLength){

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

/**
 * Created by gunther on 9/16/16.
 */
public class Leg {

    private int legId;
    private Waypoint start;
    private Waypoint end;
    private Double distance;
    private Double elevation;
    private int routeId;

    public Leg(){

    }

    public Leg(int legId, Waypoint start, Waypoint end, Double distance, Double elevation, int routeId) {
        this.legId = legId;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.elevation = elevation;
        this.routeId = routeId;
    }

    public int getLegId() {
        return legId;
    }

    public void setLegId(int legId) {
        this.legId = legId;
    }

    public Waypoint getStart() {
        return start;
    }

    public void setStart(Waypoint start) {
        this.start = start;
    }

    public Waypoint getEnd() {
        return end;
    }

    public void setEnd(Waypoint end) {
        this.end = end;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}

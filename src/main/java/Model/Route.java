package Model;

import Model.RouteResponse.*;

public class Route {
    private String origin;
    private String destiny;
    private String date;
    private String time;
    private String distance;
    private ResponseJson route;

    public Route(String origin, String destiny, String date, String time, String distance, ResponseJson route) {
        this.origin = origin;
        this.destiny = destiny;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.route = route;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDistance() {
        return distance;
    }

    public ResponseJson getRoute() {
        return route;
    }
}

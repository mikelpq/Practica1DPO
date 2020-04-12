package Model;

import java.time.LocalDate;
import java.util.Date;

public class LocationFav extends Location {
    private Date date;
    private String tipus;

    public LocationFav(String name, double[] coordinates, String description, String tipus) {
        super(name, coordinates, description);
        this.date = new Date();
        this.tipus = tipus;
    }

    public Date getDate() {
        return date;
    }
}

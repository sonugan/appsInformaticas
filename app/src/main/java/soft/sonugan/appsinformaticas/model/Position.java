package soft.sonugan.appsinformaticas.model;

import android.location.Location;

/**
 * Created by gaston on 02/06/2018.
 */

public class Position {
    private Location location;

    public Position(Location location)
    {
        this.location = location;
    }

    public double getLatitud()
    {
        return this.location.getLatitude();
    }

    public double getLongitud() { return this.location.getLongitude(); }
}

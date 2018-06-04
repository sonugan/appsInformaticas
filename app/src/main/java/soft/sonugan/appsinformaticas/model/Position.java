package soft.sonugan.appsinformaticas.model;

import android.location.Location;

import soft.sonugan.appsinformaticas.model.exceptions.CoordenadeOutOfRangeException;
import soft.sonugan.appsinformaticas.model.exceptions.NullPositionException;

/**
 * Created by gaston on 02/06/2018.
 */

public class Position {
    //private Location location;
    private double latitude;
    private double longitude;

    private final static double MIN_LATITUDE_VALUE = -90;
    private final static double MAX_LATITUDE_VALUE =90;
    private final static double MIN_LONGITUDE_VALUE = -180;
    private final static double MAX_LONGITUDE_VALUE = 180;

    public Position(Location location)
    {
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public Position(double latitude, double longitude) throws CoordenadeOutOfRangeException {
        if(!coordenadesAreInBound(latitude, longitude)){
            throw new CoordenadeOutOfRangeException();
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitud()
    {
        return this.latitude;
    }

    public double getLongitude() { return this.longitude; }

    public Position substract(Position position)throws CoordenadeOutOfRangeException, NullPositionException {
        if(position == null){ throw new NullPositionException(); }
        Position substracted = new Position(this.latitude, this.longitude);

        substracted.latitude -= position.latitude;
        substracted.longitude -= position.longitude;

        return substracted;
    }

    public double norm(){
        return Math.sqrt(Math.pow(this.latitude, 2) + Math.pow(this.longitude, 2));
    }

    public double scalarProduct(Position position){
        return position.latitude * this.latitude + position.longitude * this.longitude;
    }

    public double angle(Position position){
        double num = (position.latitude*this.latitude + position.longitude*this.longitude);
        double den = (Math.sqrt(Math.pow(this.latitude, 2) + Math.pow(this.longitude, 2))
                * (Math.sqrt(Math.pow(position.latitude, 2) + Math.pow(position.longitude, 2))) );
        double cos =  num / den;
        return Math.acos(cos);
    }

    private boolean coordenadesAreInBound(double latitude, double longitude){
        return latitude >= MIN_LATITUDE_VALUE
                && latitude <= MAX_LATITUDE_VALUE
                && longitude >= MIN_LONGITUDE_VALUE
                && longitude <= MAX_LONGITUDE_VALUE;
    }
}

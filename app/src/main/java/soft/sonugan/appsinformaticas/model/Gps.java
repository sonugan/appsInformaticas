package soft.sonugan.appsinformaticas.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gaston on 02/06/2018.
 */
//https://developer.android.com/guide/topics/location/strategies
public class Gps implements ISensor {
    private List<ISensorObserver> observers;
    private Context context;
    private LinkedList<Position> positions;
    private final static int MAX_LOCATION_ENQUEUE = 10;

    public Gps(Context context){
        this.context = context;
        this.positions = new LinkedList<Position>();

        LocationManager locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                notifyNewLocation(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
        };
        if(context.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    private void notifyNewLocation(Location location){
        while (this.positions.size() >= MAX_LOCATION_ENQUEUE){
            this.positions.removeFirst();
        }
        this.positions.addLast(new Position(location));
        notifyChange();
    }

    public void register(ISensorObserver observer){
        this.observers.add(observer);
    }

    public void notifyChange(){
        for (ISensorObserver observer: observers) {
            observer.update(this);
        }
    }

    public Position getCurrentPosition(){
        if(this.positions.size() > 0){
            return this.positions.removeFirst();
        }
        return null;
    }
}

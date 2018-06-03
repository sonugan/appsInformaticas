package soft.sonugan.appsinformaticas.model;

import android.location.Location;

import soft.sonugan.appsinformaticas.model.ISensorObserver;

/**
 * Created by gaston on 02/06/2018.
 */

public class SensorObserver implements ISensorObserver {
    private Position currentPosition;

    @Override
    public void update(ISensor sensor) {
        if(sensor.getClass() == Gps.class){
            currentPosition = ((Gps)sensor).getCurrentPosition();
        }
    }

    public Position getCurrentLocation(){
        return this.currentPosition;
    }
}

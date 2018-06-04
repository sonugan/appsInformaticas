package soft.sonugan.appsinformaticas.model;

import android.location.Location;

import java.util.LinkedList;
import java.util.List;

import soft.sonugan.appsinformaticas.model.ISensorObserver;

/**
 * Created by gaston on 02/06/2018.
 */

public class SensorObserver implements ISensorObserver {
    private Queue<Position> lastPositions;
    private Queue<Acceleration> lastAccelerations;

    private static final int MAX_POSITION_INQUEUE = 5;
    private static final int MAX_ACCELERATIONS_INQUEUE = 5;

    public SensorObserver(){
        this.lastPositions = new Queue<Position>(MAX_POSITION_INQUEUE);
        this.lastAccelerations = new Queue<Acceleration>(MAX_ACCELERATIONS_INQUEUE);
    }

    @Override
    public void update(ISensor sensor) {
        if(sensor.getClass() == Gps.class){
            this.lastPositions.push(((Gps)sensor).getCurrentPosition());
        } else if(sensor.getClass() == Accelerometer.class){
            this.lastAccelerations.push(((Accelerometer)sensor).getCurrentAcceleration());
        }
    }

    public Position getCurrentLocation(){
        return this.lastPositions.peek();
    }

    public Queue<Position> getLastPositions() {
        return this.lastPositions;
    }

    public Acceleration getCurrentAcceleration(){
        return this.lastAccelerations.peek();
    }

    public Queue<Acceleration> getLastAccelerations() {
        return this.lastAccelerations;
    }
}

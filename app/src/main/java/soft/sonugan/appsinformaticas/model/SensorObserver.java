package soft.sonugan.appsinformaticas.model;

import android.location.Location;

import java.util.LinkedList;
import java.util.List;

import soft.sonugan.appsinformaticas.model.ISensorObserver;

/**
 * Created by gaston on 02/06/2018.
 */

public class SensorObserver implements ISensorObserver {
    private LinkedList<Position> lastPositions;

    @Override
    public void update(ISensor sensor) {
        if(sensor.getClass() == Gps.class){
            addPosition(((Gps)sensor).getCurrentPosition());
        } else if(sensor.getClass() == Accelerometer.class){

        }
    }

    public Position getCurrentLocation(){
        return this.lastPositions.peek();
    }
    public List<Position> getLastPositions() { return this.lastPositions; }

    private void addPosition(Position position){
        if(lastPositions.size() > 5){
            lastPositions.removeFirst();
        }
        lastPositions.addLast(position);
    }
}

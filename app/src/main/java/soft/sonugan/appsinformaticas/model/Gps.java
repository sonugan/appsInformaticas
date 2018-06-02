package soft.sonugan.appsinformaticas.model;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.util.List;

/**
 * Created by gaston on 02/06/2018.
 */
//https://developer.android.com/guide/topics/location/strategies
public class Gps implements ISensor {
    private List<ISensorObserver> observers;

    public void register(ISensorObserver observer)
    {
        this.observers.add(observer);
    }

    public void notifyChange()
    {
        for (ISensorObserver observer: observers) {
            observer.update(this);
        }
    }
}

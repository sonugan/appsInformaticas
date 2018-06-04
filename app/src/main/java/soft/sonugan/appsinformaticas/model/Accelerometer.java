package soft.sonugan.appsinformaticas.model;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.LocationManager;

import java.security.PrivilegedAction;
import java.util.List;

/**
 * Created by gaston on 02/06/2018.
 */

public class Accelerometer implements ISensor, SensorEventListener {
    private List<ISensorObserver> observers;
    private Context context;
    private SensorManager sensorManager;
    private Sensor senAccelerometer;
    private Chronometer chronometer;
    private Acceleration currentAcceleration;

    public Accelerometer(Context context) {
        this.context = context;
        sensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
        this.chronometer = new Chronometer(System.currentTimeMillis(), 200);
    }

    public void register(ISensorObserver observer)
    {
        this.observers.add(observer);
    }

    @Override
    public void notifyChange() {
        for (ISensorObserver observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometerValue(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public Acceleration getCurrentAcceleration(){
        return this.currentAcceleration;
    }

    private void getAccelerometerValue(SensorEvent event) {
        float[] values = event.values;
        this.currentAcceleration = new Acceleration(values[0], values[1], values[2]);

        if (this.chronometer.check(event.timestamp)) {
            notifyChange();
        }
    }
}

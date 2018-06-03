package soft.sonugan.appsinformaticas.model;

/**
 * Created by gaston on 02/06/2018.
 */

public class SensorManager {
    SensorObserver sensorObserver;
    AccidentDetector accidentDetector;

    public SensorManager(){
        this.sensorObserver = new SensorObserver();
        this.accidentDetector = new AccidentDetector();
    }

    public Accident Detect()
    {
        //TODO
        return null;
    }
}

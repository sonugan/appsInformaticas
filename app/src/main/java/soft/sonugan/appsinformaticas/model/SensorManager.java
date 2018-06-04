package soft.sonugan.appsinformaticas.model;

/**
 * Created by gaston on 02/06/2018.
 */

public class SensorManager {
    SensorObserver sensorObserver;
    AccidentDetector accidentDetectorChain;

    public SensorManager(){
        this.sensorObserver = new SensorObserver();
        this.accidentDetectorChain = new NoAccidentDetector(null);
    }

    public Accident detect(ContextParameters parameters){
        return this.accidentDetectorChain.detect(parameters);
    }
}

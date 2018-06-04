package soft.sonugan.appsinformaticas.model;

import soft.sonugan.appsinformaticas.model.detectors.NoAccidentDetector;

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

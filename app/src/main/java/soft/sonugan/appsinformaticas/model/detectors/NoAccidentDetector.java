package soft.sonugan.appsinformaticas.model.detectors;

import soft.sonugan.appsinformaticas.model.Acceleration;
import soft.sonugan.appsinformaticas.model.Accident;
import soft.sonugan.appsinformaticas.model.AccidentDetector;
import soft.sonugan.appsinformaticas.model.ContextParameters;

/**
 * Created by gaston on 03/06/2018.
 */

public class NoAccidentDetector extends AccidentDetector {

    public NoAccidentDetector(AccidentDetector next){
        super(next);
    }

    @Override
    public Accident detect(ContextParameters parameters) {
        return super.detect(parameters);
    }

    private void checkDirection(ContextParameters parameters){

    }

    private void checkAcceleration(ContextParameters parameters){
        for(Object a : parameters.lastAccelerations){
            Acceleration acceleration = (Acceleration)a;

        }
    }
}

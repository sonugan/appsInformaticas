package soft.sonugan.appsinformaticas.model.detectors;

import java.util.LinkedList;
import java.util.List;

import soft.sonugan.appsinformaticas.model.Acceleration;
import soft.sonugan.appsinformaticas.model.Accident;
import soft.sonugan.appsinformaticas.model.AccidentDetector;
import soft.sonugan.appsinformaticas.model.ContextParameters;
import soft.sonugan.appsinformaticas.model.DirectionVector;
import soft.sonugan.appsinformaticas.model.Position;

/**
 * Created by gaston on 03/06/2018.
 */

public class SuddenStopDetector extends AccidentDetector {

    public SuddenStopDetector(AccidentDetector next){
        super(next);
    }

    @Override
    public Accident detect(ContextParameters parameters) {
        return super.detect(parameters);
    }

    private boolean accelerationIsOpossed(ContextParameters parameters){
        try {
            List<Position> directions = new LinkedList<Position>();
            DirectionVector previousVector = parameters.lastDirectionVectors.size() > 0? parameters.lastDirectionVectors.get(1) : null;
            DirectionVector lastVector = parameters.lastDirectionVectors.get(0);

            if(previousVector != null)
            {
                double angle = previousVector.angle(lastVector);
                if(angle > 90 || angle < -90){ //La direccion debe ser opuesta
                    return true;
                }
            }
        } catch (Exception e){

        }
        return false;
    }

    private void checkAcceleration(ContextParameters parameters){
        for(Object a : parameters.lastAccelerations){
            Acceleration acceleration = (Acceleration)a;
        }
    }
}

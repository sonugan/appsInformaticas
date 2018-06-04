package soft.sonugan.appsinformaticas.model;

import soft.sonugan.appsinformaticas.model.exceptions.CoordenadeOutOfRangeException;
import soft.sonugan.appsinformaticas.model.exceptions.NullPositionException;

/**
 * Created by gaston on 02/06/2018.
 */

public abstract class AccidentDetector {
    AccidentDetector next;

    public AccidentDetector(AccidentDetector next) {
        this.next = next;
    }

    public Accident detect(ContextParameters parameters){
        if(this.next != null){
            return this.next.detect(parameters);
        }
        return null;
    }
}

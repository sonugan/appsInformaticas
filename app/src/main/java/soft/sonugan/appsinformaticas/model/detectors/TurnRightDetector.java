package soft.sonugan.appsinformaticas.model.detectors;

import soft.sonugan.appsinformaticas.model.Accident;
import soft.sonugan.appsinformaticas.model.ContextParameters;

/**
 * Created by gaston on 02/06/2018.
 */

public abstract class TurnRightDetector {
    TurnRightDetector next;

    public TurnRightDetector(TurnRightDetector next) {
        this.next = next;
    }

    public Accident detect(ContextParameters parameters){
        if(this.next != null){
            return this.next.detect(parameters);
        }
        return null;
    }
}

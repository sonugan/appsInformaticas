package soft.sonugan.appsinformaticas.model;

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
}

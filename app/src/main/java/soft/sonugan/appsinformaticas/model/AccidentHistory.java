package soft.sonugan.appsinformaticas.model;

import java.util.List;

/**
 * Created by gaston on 02/06/2018.
 */

public class AccidentHistory {
    private List<Accident> accidents;

    public void add(Accident accident){
        this.accidents.add(accident);
    }

    public Accident informAccidentPath() {
        return accidents.get(0);//TODO: hacer
    }
}

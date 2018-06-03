package soft.sonugan.appsinformaticas.model;

import java.sql.Timestamp;

/**
 * Created by gaston on 02/06/2018.
 */

public class PositionHistory {
    private Timestamp time;
    private Position position;

    public PositionHistory(Timestamp time, Position position){
        this.time = time;
        this.position = position;
    }

    public Timestamp getTime(){
        return this.time;
    }

    public Position getPosition(){
        return this.position;
    }
}

package soft.sonugan.appsinformaticas.model;

import android.os.health.TimerStat;

import java.sql.Timestamp;

/**
 * Created by gaston on 02/06/2018.
 */

public class Accident {
    Timestamp time;

    public Accident(Timestamp time){
        this.time = time;
    }

    public Timestamp getTime(){
        return this.time;
    }
}

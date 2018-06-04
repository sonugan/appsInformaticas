package soft.sonugan.appsinformaticas.model;

import java.sql.Timestamp;

public class Chronometer {
    private long lastCheckMillisecs;
    private long checkEvery;

    public Chronometer(long initMillisecs, long checkEvery){
        this.lastCheckMillisecs = initMillisecs;
        this.checkEvery = checkEvery;
    }

    public boolean check(long currentMillisecs){
        if(currentMillisecs >= this.lastCheckMillisecs + this.checkEvery){
            this.lastCheckMillisecs = currentMillisecs;
            return true;
        }
        return false;
    }
}

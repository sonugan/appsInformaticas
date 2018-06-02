package soft.sonugan.appsinformaticas.model;

import java.util.List;

/**
 * Created by gaston on 02/06/2018.
 */

public class Accelerometer implements ISensor {
    private List<ISensorObserver> observers;

    public void register(ISensorObserver observer)
    {
        this.observers.add(observer);
    }

    public void notifyChange()
    {
        for (ISensorObserver observer: observers) {
            observer.update(this);
        }
    }
}

package soft.sonugan.appsinformaticas.model;

/**
 * Created by gaston on 02/06/2018.
 */

public interface ISensor {
    void register(ISensorObserver observer);
    void notifyChange();
}

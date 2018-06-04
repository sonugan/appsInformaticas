package soft.sonugan.appsinformaticas.model;

import android.location.Location;

import java.util.List;

/**
 * Created by gaston on 03/06/2018.
 */

public class ContextParameters {
    public Queue<Position> lastPositions;
    public Queue<DirectionVector> lastDirectionVectors;
    public DirectionVector directionVector;
    public Queue<Acceleration> lastAccelerations;
}

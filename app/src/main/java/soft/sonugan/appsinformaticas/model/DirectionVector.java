package soft.sonugan.appsinformaticas.model;

import soft.sonugan.appsinformaticas.model.exceptions.CoordenadeOutOfRangeException;
import soft.sonugan.appsinformaticas.model.exceptions.NullPositionException;

import static java.lang.Math.sqrt;

/**
 * Created by gaston on 02/06/2018.
 */

public class DirectionVector {
    private Position primaryVector;
    private Position secondaryVector;

    public DirectionVector(Position primaryVector, Position secondaryVector){
        this.primaryVector = primaryVector;
        this.secondaryVector = secondaryVector;
    }

    public Position getPrimaryVector(){
        return this.primaryVector;
    }

    public Position getSecondaryVector(){
        return this.secondaryVector;
    }

    public Position getDirection() throws CoordenadeOutOfRangeException, NullPositionException {
        return this.primaryVector.substract(this.secondaryVector);
    }
}

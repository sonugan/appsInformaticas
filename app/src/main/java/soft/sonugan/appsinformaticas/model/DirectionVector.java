package soft.sonugan.appsinformaticas.model;

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
}

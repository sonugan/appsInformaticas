package soft.sonugan.appsinformaticas;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.*;

import java.util.Arrays;

import soft.sonugan.appsinformaticas.model.Position;
import soft.sonugan.appsinformaticas.model.exceptions.CoordenadeOutOfRangeException;
import soft.sonugan.appsinformaticas.model.exceptions.NullPositionException;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaston on 03/06/2018.
 */
@RunWith(value = Parameterized.class)
public class PositionTest{

    Position position1;
    Position position2;
    Position positionExpected;
    String method;
    public PositionTest(String method, Position position1, Position position2, Position positionExpected) {
        this.method = method;
        this.position1 = position1;
        this.position2 = position2;
        this.positionExpected = positionExpected;
    }

    @Test(expected = CoordenadeOutOfRangeException.class)
    public void createWithLatitudeUpperThanUpperLimit() throws Exception {
        Position position = new Position(90.1,3);
    }

    @Test(expected = CoordenadeOutOfRangeException.class)
    public void createWithLatitudeLowerThanUpperLimit() throws Exception {
        Position position = new Position(-90.1,3);
    }

    @Test
    public void getLatitudeIntValue() throws Exception {
        Position position = new Position(1,3);
        assertEquals(1, position.getLatitud(),0);
    }

    @Test
    public void getLatitudeDecimalPositiveValue() throws Exception {
        Position position = new Position(1.323456,3);
        assertEquals(1.323456, position.getLatitud(),0);
    }

    @Test(expected = CoordenadeOutOfRangeException.class)
    public void createWithLongitudeUpperThanUpperLimit() throws Exception {
        Position position = new Position(3,180.1);
    }

    @Test(expected = CoordenadeOutOfRangeException.class)
    public void createWithLongitudeLowerThanUpperLimit() throws Exception {
        Position position = new Position(3,-180.1);
    }

    @Test
    public void getLongitudeIntValue() throws Exception {
        Position position = new Position(1,3);
        assertEquals(3, position.getLongitude(),0);
    }

    @Test
    public void getLongitudeDecimalPositiveValue() throws Exception {
        Position position = new Position(3,1.323456);
        assertEquals(1.323456, position.getLongitude(),0);
    }

    @Test(expected = NullPositionException.class)
    public void substractNullPosition() throws Exception {
        Position position = new Position(3,1);
        position.substract(null);
    }


    @Parameterized.Parameters(name= "{index}: isCorrect({0})={1}")
    public static Iterable<Object[]> data() throws CoordenadeOutOfRangeException {
        return Arrays.asList(new Object[][]{
                {"substract", new Position(1,1), new Position(2,2), new Position(-1,-1)},
                {"substract", new Position(10,1), new Position(2,2), new Position(8,-1)},
                {"substract", new Position(1.0892,1), new Position(2,2), new Position(-0.9108,-1)},
        });
    }

    @Test
    public void substract() throws Exception {
        assumeThat(method, is("substract"));
        Position substracted = position1.substract(position2);
        assertEquals(positionExpected.getLatitud(), substracted.getLatitud(), 0);
        assertEquals(positionExpected.getLongitude(), substracted.getLongitude(), 0);
    }
}

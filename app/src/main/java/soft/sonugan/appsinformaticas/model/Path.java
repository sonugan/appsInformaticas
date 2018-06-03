package soft.sonugan.appsinformaticas.model;

import android.util.Range;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 02/06/2018.
 */

public class Path {
    private Range<Date> range;
    private List<PositionHistory> positions;

    public Path(Range<Date> range){
        this.positions = new ArrayList<PositionHistory>();
    }
}

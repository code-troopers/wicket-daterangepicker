package codetroopers.wicket.web.daterangepicker;

import java.io.Serializable;
import java.util.Date;

/**
* @author cgatay
*/
public class DateRangePair implements Serializable {

    private final Date startDate;
    private final Date endDate;

    public DateRangePair(final Date startDate, final Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}

package codetroopers.wicket.web.daterangepicker;

import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converter.DateConverter;

import java.util.Date;
import java.util.Locale;

/**
* @author cgatay
*/
public class DatePairConverter implements IConverter<DateRangePair> {

    private DateConverter dateConverter;

    public DatePairConverter() {
        dateConverter = new DateConverter();
    }

    @Override
    public String convertToString(final DateRangePair value, final Locale locale) {
        if (value.getStartDate() != null && value.getEndDate() != null) {
            return dateConverter.convertToString(value.getStartDate(), locale) + " - " +
                   dateConverter.convertToString(value.getEndDate(), locale);
        }
        return "";
    }

    @Override
    public DateRangePair convertToObject(final String value, final Locale locale) {
        if (value != null) {
            final String[] chunks = value.split(" - ");
            if (chunks != null && chunks.length == 2) {
                final Date startDate = dateConverter.convertToObject(chunks[0], locale);
                final Date endDate = dateConverter.convertToObject(chunks[1], locale);
                return new DateRangePair(startDate, endDate);
            }
        }
        return null;
    }
}

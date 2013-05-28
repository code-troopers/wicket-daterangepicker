package codetroopers.wicket.web.daterangepicker;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author cgatay
 */
public class DatePairConverterTest {
    private Date birth;
    private Date epoch;
    private DatePairConverter datePairConverter;

    @Before
    public void setUp() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        birth = new Date(452995200000L);
        epoch = new Date(0);
        datePairConverter = new DatePairConverter();
    }

    @Test
    public void testConvertFrenchRangeToString() throws Exception {
        final String s = datePairConverter.convertToString(new DateRangePair(epoch, birth), Locale.FRENCH);
        Assert.assertEquals("01/01/70 - 10/05/84", s);
    }
    
    @Test
    public void testConvertEnglishRangeToString() throws Exception {
        final String s = datePairConverter.convertToString(new DateRangePair(epoch, birth), Locale.ENGLISH);
        Assert.assertEquals("1/1/70 - 5/10/84", s);
    }

    @Test
    public void testConvertFrenchDatePairToString() throws Exception {
        final DateRangePair dateRangePair =
                datePairConverter.convertToObject("01/01/70 - 10/05/84", Locale.FRANCE);
        Assert.assertEquals(epoch, dateRangePair.getStartDate());
        Assert.assertEquals(birth, dateRangePair.getEndDate());
    }

    @Test
    public void testConvertEnglishDatePairToString() throws Exception {
        final DateRangePair dateRangePair =
                datePairConverter.convertToObject("1/1/70 - 5/10/84", Locale.ENGLISH);
        Assert.assertEquals(epoch, dateRangePair.getStartDate());
        Assert.assertEquals(birth, dateRangePair.getEndDate());
    }
}

package codetroopers.wicket.web.daterangepicker;

import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.tester.WicketTester;
import org.apache.wicket.util.tester.WicketTesterHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cgatay
 */
public class DateRangePickerBehaviorTest {

    private WicketTester wicketTester;

    @Before
    public void setUp() throws Exception {
        wicketTester = new WicketTester();
    }

    @Test
    public void testBindOnTextFieldOk() throws Exception {
        final TextField textField = new TextField("dummy");
        textField.add(new DateRangePickerBehavior());
        final Behavior behavior = WicketTesterHelper.findBehavior(textField, DateRangePickerBehavior.class);
        Assert.assertNotNull("The behavior should have been attached to the component", behavior);
    }

    @Test
    public void testBindOnComponentKO() throws Exception {
        final WebMarkupContainer wmc = new WebMarkupContainer("dummy");
        try {
            wmc.add(new DateRangePickerBehavior());
            Assert.fail("The behavior should not be bound to anything but a Textfield");
        } catch (WicketRuntimeException e) {
            final Behavior behavior = WicketTesterHelper.findBehavior(wmc, DateRangePickerBehavior.class);
            Assert.assertNull("The behavior should not been still attached to the component", behavior);
        }
    }

    @Test
    public void testOutputMarkupIdIsCalledOnComponent() throws Exception {
        final TextField dummy = new TextField("dummy");
        Assert.assertFalse("The #getOutputMarkupId flag should be set to false", dummy.getOutputMarkupId());
        dummy.add(new DateRangePickerBehavior());
        Assert.assertTrue("The #getOutputMarkupId flag should be set to true", dummy.getOutputMarkupId());
    }

    @Test
    public void testRegisterSpecificConverterIfAbsent() throws Exception {
        final TextField textField = new TextField("dummy");
        final IConverterLocator converterLocator = wicketTester.getApplication().getConverterLocator();
        Assert.assertTrue("The default IConverterLocator is not an instance of ConverterLocator", 
                          converterLocator instanceof ConverterLocator);
        Assert.assertNull("There should not be a Converter set on application for DateRangePair",
                          ((ConverterLocator) converterLocator).get(DateRangePair.class));
        textField.add(new DateRangePickerBehavior());
        final IConverter<DateRangePair> converter = ((ConverterLocator) converterLocator).get(DateRangePair.class);
        Assert.assertNotNull("The converter should have been registered",
                             converter);
        Assert.assertTrue("The converter should be an instance of DatePairConverter",
                          converter instanceof DatePairConverter);
    }
}

package codetroopers.wicket.web.daterangepicker;

import codetroopers.wicket.web.daterangepicker.javascript.DateRangePickerOptions;
import codetroopers.wicket.web.daterangepicker.javascript.DateRangePickerReference;
import org.apache.wicket.Component;
import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.convert.IConverter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * @author cgatay
 */
public class DateRangePickerBehavior extends Behavior {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateRangePickerBehavior.class);

    @Override
    public void bind(final Component component) {
        super.bind(component);
        if (!(component instanceof TextField)) {
            component.remove(this);
            throw new WicketRuntimeException("DateRangePickerBehavior must be bound to a Textfield");
        }
        final IConverterLocator converterLocator = component.getApplication().getConverterLocator();
        if (converterLocator instanceof ConverterLocator) {
            final IConverter<DateRangePair> converter =
                    ((ConverterLocator) converterLocator).get(DateRangePair.class);
            if (converter == null) {
                LOGGER.info(
                        "There is no DateRangePair converter registered in the application, trying to register one...");
                ((ConverterLocator) converterLocator).set(DateRangePair.class, new DatePairConverter());

            }
        } else {
            LOGGER.error(
                    "Can't automatically verify DateRangePair converter presence ! (custom ConverterLocator is used)");
        }
        component.setOutputMarkupId(true);
    }

    @Override
    public void renderHead(final Component component, final IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(JavaScriptHeaderItem.forReference(new DateRangePickerReference()));
        response.render(OnLoadHeaderItem.forScript(buildScript(component)));
    }

    private CharSequence buildScript(final Component component) {
        final StringBuilder stringBuilder = new StringBuilder();
        setMomentLocale(component, stringBuilder);
        return stringBuilder.append("$('#").append(component.getMarkupId())
                .append("').daterangepicker(").append(toJson(getPickerOptions(component))).append(");");
    }

    protected void setMomentLocale(final Component component, final StringBuilder stringBuilder) {
        if (Locale.FRENCH.getLanguage().equals(component.getLocale().getLanguage())){
            stringBuilder.append("moment.lang('fr');");
        }else{
            stringBuilder.append("moment.lang('en');");
        }
    }

    protected DateRangePickerOptions getPickerOptions(final Component component) {
        if (Locale.FRENCH.getLanguage().equals(component.getLocale().getLanguage())) {
            return DateRangePickerOptions.getDefaultFrench();
        } else {
            return DateRangePickerOptions.getDefaultEnglish();
        }
    }

    private static JsonNode toJson(final DateRangePickerOptions pickerOptions) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper.valueToTree(pickerOptions);
    }

}

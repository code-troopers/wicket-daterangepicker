package codetroopers.wicket.web.daterangepicker.javascript;

import com.google.common.collect.Lists;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import java.util.ArrayList;

/**
 * @author cgatay
 */
public class DateRangePickerReference extends JQueryPluginResourceReference {
    public DateRangePickerReference() {
        super(DateRangePickerReference.class, "daterangepicker.js");
    }

    @Override
    public Iterable<? extends HeaderItem> getDependencies() {
        final Iterable<? extends HeaderItem> dependencies = super.getDependencies();
        final ArrayList<HeaderItem> superDependencies = Lists.newArrayList(dependencies);
        superDependencies.add(
                JavaScriptHeaderItem.forReference(new WebjarsJavaScriptResourceReference("momentjs/current/moment.js")));
        superDependencies.add(
                JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(getClass(), "moment_fr.js")));
        superDependencies.add(CssHeaderItem.forReference(new CssResourceReference(getClass(), "daterangepicker.css")));
        return superDependencies;
    }
    
}

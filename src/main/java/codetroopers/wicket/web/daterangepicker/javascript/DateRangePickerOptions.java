package codetroopers.wicket.web.daterangepicker.javascript;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @author cgatay
*/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DateRangePickerOptions implements Serializable {
    private String format;
    private String applyClass;
    private String clearClass;
    private Date startDate;
    private Date endDate;
    private Date minDate;
    private Date maxDate;
    private Map<String,Date[]> ranges;
    private Date dateLimit;
    private String opens;
    private String showWeekNumbers;
    private String buttonClasses;
    private Boolean showDropdowns;
    private Boolean dropDownAdjusts;
    
    private final LocaleOptions locale;
    
    public DateRangePickerOptions(final String format) {
        this.locale = new LocaleOptions();
        this.ranges = new LinkedHashMap<>();
        this.format = format;
    }

    public static DateRangePickerOptions getDefaultFrench() {
        final DateRangePickerOptions pickerOptions = new DateRangePickerOptions("DD/MM/YY");
        pickerOptions.getLocale()
                .setApplyLabel("Appliquer")
                .setClearLabel("Effacer")
                .setFromLabel("Du")
                .setToLabel("au")
                .setWeekLabel("Sem.")
                .setCustomRange("Plage perso.");
        return pickerOptions;
    }

    public static DateRangePickerOptions getDefaultEnglish() {
        return new DateRangePickerOptions("MM/DD/YY");
    }

    public String getApplyClass() {
        return applyClass;
    }

    public void setApplyClass(final String applyClass) {
        this.applyClass = applyClass;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }

    public LocaleOptions getLocale() {
        return locale;
    }

    public String getClearClass() {
        return clearClass;
    }

    public void setClearClass(final String clearClass) {
        this.clearClass = clearClass;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(final Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(final Date maxDate) {
        this.maxDate = maxDate;
    }

    public Map<String,Date[]> getRanges() {
        return ranges;
    }
    
    public DateRangePickerOptions addRange(String name, Date startDate, Date endDate){
        getRanges().put(name, new Date[]{startDate, endDate});
        return this;
    }

    public Date getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(final Date dateLimit) {
        this.dateLimit = dateLimit;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(final String opens) {
        this.opens = opens;
    }

    public String getShowWeekNumbers() {
        return showWeekNumbers;
    }

    public void setShowWeekNumbers(final String showWeekNumbers) {
        this.showWeekNumbers = showWeekNumbers;
    }

    public String getButtonClasses() {
        return buttonClasses;
    }

    public void setButtonClasses(final String buttonClasses) {
        this.buttonClasses = buttonClasses;
    }

    public Boolean getShowDropdowns() {
        return showDropdowns;
    }

    public void setShowDropdowns(final Boolean showDropdowns) {
        this.showDropdowns = showDropdowns;
    }

    public Boolean getDropDownAdjusts() {
        return dropDownAdjusts;
    }

    public void setDropDownAdjusts(final Boolean dropDownAdjusts) {
        this.dropDownAdjusts = dropDownAdjusts;
    }

    public static class LocaleOptions implements Serializable{
        private String applyLabel;
        private String clearLabel;
        private String fromLabel;
        private String toLabel;
        private String weekLabel;
        private String customRange;

        public String getApplyLabel() {
            return applyLabel;
        }

        public LocaleOptions setApplyLabel(final String applyLabel) {
            this.applyLabel = applyLabel;
            return this;
        }

        public String getClearLabel() {
            return clearLabel;
        }

        public LocaleOptions setClearLabel(final String clearLabel) {
            this.clearLabel = clearLabel;
            return this;
        }

        public String getFromLabel() {
            return fromLabel;
        }

        public LocaleOptions setFromLabel(final String fromLabel) {
            this.fromLabel = fromLabel;
            return this;
        }

        public String getToLabel() {
            return toLabel;
        }

        public LocaleOptions setToLabel(final String toLabel) {
            this.toLabel = toLabel;
            return this;
        }

        public String getWeekLabel() {
            return weekLabel;
        }

        public LocaleOptions setWeekLabel(final String weekLabel) {
            this.weekLabel = weekLabel;
            return this;
        }

        public String getCustomRange() {
            return customRange;
        }

        public LocaleOptions setCustomRange(final String customRange) {
            this.customRange = customRange;
            return this;
        }
    }
}

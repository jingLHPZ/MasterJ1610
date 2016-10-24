package com.sxt.base.common;
import java.util.ArrayList;
import java.util.List;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class Property {
    private String property;
    private String value;

    public Property() {
    }

    public Property(String property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return this.property;
    }

    public String getValue() {
        return this.value;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static List<Property> parseFilters(String filter) {
        if(StringUtils.isBlank(filter)) {
            return null;
        } else {
            JSONArray array = (JSONArray)JSONValue.parse(filter);
            if(CollectionUtils.isEmpty(array)) {
                return null;
            } else {
                ArrayList filters = new ArrayList(array.size());
                JSONObject jsonObject = null;
                String property = null;
                String value = null;

                for(int i = 0; i < array.size(); ++i) {
                    jsonObject = (JSONObject)array.get(i);
                    property = jsonObject.getAsString("property");
                    value = jsonObject.getAsString("value");
                    if(StringUtils.isNotBlank(property) && StringUtils.isNotBlank(value) && !"-1".equals(value)) {
                        filters.add(new Property(property, value));
                    }
                }

                return filters;
            }
        }
    }

}

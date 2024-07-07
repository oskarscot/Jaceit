package scot.oskar.jaceit.internal.web.check.impl;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.util.Map;

public class IntegerCheck implements ParameterCheck {

    @Override
    public boolean test(Map<String, String> params, String paramKey) {
        String param = params.get(paramKey);
        return param != null && param.matches("\\d+");
    }
}
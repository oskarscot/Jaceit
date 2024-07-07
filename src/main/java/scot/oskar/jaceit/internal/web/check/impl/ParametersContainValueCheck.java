package scot.oskar.jaceit.internal.web.check.impl;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.util.Map;

public class ParametersContainValueCheck implements ParameterCheck {

    private final String parameter;

    public ParametersContainValueCheck(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean test(Map<String, String> params, String param) {
        return params.containsKey(this.parameter);
    }
}

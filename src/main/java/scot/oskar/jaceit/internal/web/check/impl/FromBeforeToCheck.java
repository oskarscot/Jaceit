package scot.oskar.jaceit.internal.web.check.impl;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.util.Map;

public class FromBeforeToCheck implements ParameterCheck {

    @Override
    public boolean test(Map<String, String> params, String paramKey) {
        try {
            int from = Integer.parseInt(params.get("from"));
            int to = Integer.parseInt(params.get("to"));
            return from <= to;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

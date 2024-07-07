package scot.oskar.jaceit.internal.web.check.impl;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.util.Map;

public class LimitCheck implements ParameterCheck {

    private final int limit;

    public LimitCheck(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean test(Map<String, String> params, String param) {
        if (params.containsKey("limit")) {
            try {
                int limit = Integer.parseInt(params.get("limit"));
                return limit <= this.limit;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}

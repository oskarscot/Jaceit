package scot.oskar.jaceit.internal.web.check;

import java.util.Map;

public class OffsetDivisibleByLimitCheck implements ParameterCheck {

    @Override
    public boolean test(Map<String, String> params, String paramKey) {
        if (params.containsKey("offset") && params.containsKey("limit")) {
            try {
                int offset = Integer.parseInt(params.get("offset"));
                int limit = Integer.parseInt(params.get("limit"));
                return offset % limit == 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}


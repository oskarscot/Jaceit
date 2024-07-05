package scot.oskar.jaceit.internal.web.check;

import java.util.Map;

public class NonNegativeCheck implements ParameterCheck {

    @Override
    public boolean test(Map<String, String> params, String paramKey) {
        String param = params.get(paramKey);
        try {
            return param != null && Integer.parseInt(param) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
package scot.oskar.jaceit.internal.web.check;

import java.util.Map;

public interface ParameterCheck {
    boolean test(Map<String, String> params, String param);
}

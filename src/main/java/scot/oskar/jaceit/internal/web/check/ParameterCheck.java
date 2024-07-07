package scot.oskar.jaceit.internal.web.check;

import java.util.Map;

/**
 *  ParameterCheck interface, used to validate parameters within an url.
 *  Implementations of this interface should be stateless and thread-safe.
 */
public interface ParameterCheck {

    /**
     * Test whether the condition is true or not, used to validate parameters within
     * a url.
     *
     * @param params a map of all query parameters
     * @param param the parameter we're testing against
     * @return whether the condition is true or not
     */
    boolean test(Map<String, String> params, String param);
}

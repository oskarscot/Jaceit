package scot.oskar.jaceit.internal.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.internal.web.QueryValidator;
import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.util.List;
import java.util.Map;

public class ValidationUtil {

    private static final Logger logger = LoggerFactory.getLogger("Validator");

    private ValidationUtil() { }

    public static void validateUrl(String url, Map<String, List<ParameterCheck>> checks) {
        QueryValidator validator = new QueryValidator();
        checks.forEach((key, checkList) -> checkList.forEach(check -> validator.addCheck(key, check)));

        if (validator.invalid(url)) {
            logger.warn("Invalid query parameters: {}", validator.getErrors());
            throw new IllegalArgumentException("Invalid query parameters");
        }
    }

}

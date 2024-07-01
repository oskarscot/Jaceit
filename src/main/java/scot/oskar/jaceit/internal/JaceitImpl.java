package scot.oskar.jaceit;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import scot.oskar.jaceit.web.ApiClient;

import java.util.logging.Logger;

public class Jaceit {

    private final Logger logger = Logger.getLogger(Jaceit.class.getName());
    private final String apiKey;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private ApiClient apiClient;

    protected Jaceit(String apiKey, OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;

        
    }


}

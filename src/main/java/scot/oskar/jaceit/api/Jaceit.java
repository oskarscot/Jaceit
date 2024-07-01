package scot.oskar.jaceit.api;

import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.request.ApiClient;

public interface Jaceit {

    ApiClient apiClient();
    Players players();
}

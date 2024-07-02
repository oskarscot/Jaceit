package scot.oskar.jaceit.api;

import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.request.ApiClient;

public interface Jaceit {

    /**
     *  Gets the api client that is used to make web requests to the faceit api.
     *
     * @return the api client used to make requests
     */
    ApiClient apiClient();

    /**
     * Gets the players endpoint that is used to get player information.
     *
     * @return the players endpoint
     */
    Players players();
}

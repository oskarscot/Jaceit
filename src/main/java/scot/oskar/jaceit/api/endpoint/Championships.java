package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.championship.ChampionshipResponse;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.QueryParameters;

public interface Championships {

    ChampionshipResponse getChampionships(String game);

    ChampionshipResponse getChampionships(String game, ChampionshipType type);

    ChampionshipResponse getChampionships(String game, ChampionshipType type, QueryParameters queryParameters);
}

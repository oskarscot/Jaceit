package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.championship.AllChampionships;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.QueryParameters;

public interface Championships {

    AllChampionships getAll(String game);

    AllChampionships getAll(String game, ChampionshipType type);

    AllChampionships getAll(String game, ChampionshipType type, QueryParameters queryParameters);
}

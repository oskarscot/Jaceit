package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.championship.AllChampionships;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.QueryParameters;

import java.util.concurrent.CompletableFuture;

public interface Championships {

    AllChampionships getAll(String game);

    CompletableFuture<AllChampionships> getAllAsync(String game);

    AllChampionships getAll(String game, ChampionshipType type);

    CompletableFuture<AllChampionships> getAllAsync(String game, ChampionshipType type);

    AllChampionships getAll(String game, ChampionshipType type, QueryParameters queryParameters);

    CompletableFuture<AllChampionships> getAllAsync(String game, ChampionshipType type, QueryParameters queryParameters);
}

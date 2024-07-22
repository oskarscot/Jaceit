package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.championship.GameChampionship;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.QueryParameters;

import java.util.concurrent.CompletableFuture;

public interface Championships {

    GameChampionship getAll(String game);

    CompletableFuture<GameChampionship> getAllAsync(String game);

    GameChampionship getAll(String game, ChampionshipType type);

    CompletableFuture<GameChampionship> getAllAsync(String game, ChampionshipType type);

    GameChampionship getAll(String game, ChampionshipType type, QueryParameters queryParameters);

    CompletableFuture<GameChampionship> getAllAsync(String game, ChampionshipType type, QueryParameters queryParameters);


}

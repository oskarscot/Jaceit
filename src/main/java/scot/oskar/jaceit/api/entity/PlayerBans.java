package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerBansImpl;

import java.util.List;

@JsonDeserialize(as = PlayerBansImpl.class)
public interface PlayerBans {

    List<Ban> getBans();

    int getEnd();

    int getStart();

    @JsonDeserialize(as = PlayerBansImpl.BanImpl.class)
    interface Ban {

        String getEndsAt();

        String getGame();

        String getNickname();

        String getReason();

        String getStartsAt();

        String getType();

        String getUserId();

    }

}

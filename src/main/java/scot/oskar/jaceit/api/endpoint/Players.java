package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.request.QueryParameters;

public interface Players {

    PlayerProfile getDetailsById(String number);
    void getDetailsById(String number, PlayerProfile playerProfile);

    PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters);
    void getDetailsByNickname(String nickname, QueryParameters parameters, PlayerProfile playerProfile);
}

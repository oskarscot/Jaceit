package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PlayerBans {

    public int end;
    public List<Ban> items;
    public int start;

    public static class Ban {

        @JsonProperty("ends_at")
        public String endsAt;

        public String game;
        public String nickname;
        public String reason;

        @JsonProperty("starts_at")
        public String startsAt;

        public String type;

        @JsonProperty("user_id")
        public String userId;

        public String getEndsAt() {
            return endsAt;
        }

        public String getGame() {
            return game;
        }

        public String getNickname() {
            return nickname;
        }

        public String getReason() {
            return reason;
        }

        public String getStartsAt() {
            return startsAt;
        }

        public String getType() {
            return type;
        }

        public String getUserId() {
            return userId;
        }
    }

    public int getEnd() {
        return end;
    }

    public List<Ban> getBans() {
        return items;
    }

    public int getStart() {
        return start;
    }
}

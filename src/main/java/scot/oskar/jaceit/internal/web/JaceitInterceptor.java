package scot.oskar.jaceit.web;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class JaceitInterceptor implements Interceptor {

    private final String apiKey;

    public JaceitInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + apiKey)
                .build());
    }
}

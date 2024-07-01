package scot.oskar.jaceit.api.request;

public interface ApiClient {

    <T> void getAsync(String url, Class<T> responseType, ApiCallback<T> callback);

}

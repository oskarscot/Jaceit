# Jaceit - A simple and easy to use Java Wrapper for the Faceit API

WARNING: This project is still in development and is not ready for production use.

Jaceit is light, with only dependencies being `Jackson` and `OkHttp`. It is also easy to use, with a simple and clean API.

## Example

```java
public class Main {
    public static void main(String[] args) {
        final Jaceit jaceit = JaceitBuilder
                .createDefault(System.getenv("FACEIT_KEY"))
                .build();

        final PlayerProfile playerById = jaceit.players().getDetailsById("460dc92d-8af4-4260-8780-45758fa688f0");

        System.out.println(playerById.getNickname()); // Prints: tesez

        final PlayerProfile playerByName = jaceit.players().getDetailsByNickname("tesez", QueryParameters.of("game", "cs2"));

        // The URL returned by Faceit API is not localized, so we need to replace the {lang} placeholder with the desired language. 
        System.out.println(playerByName.getFaceitUrl()); // Prints: https://faceit.com/{lang}/players/tesez
    }
}

```

## TODO

- [x] Replace all logging with SLF4J
- [ ] Implement all endpoints
- [ ] Complete documentation
- [x] Redesign the ApiClient class

## Future Plans

- [ ] Webhook support
- [ ] Rate limiting support
- [ ] Caching support
- [ ] More customization options
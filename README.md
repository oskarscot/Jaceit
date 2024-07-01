# Jaceit - A simple and easy to use Java Wrapper for the Faceit API

Jaceit is light, with only dependencies being `Jackson` and `OkHttp`. It is also easy to use, with a simple and clean API.

## Example

```java
public class Main {
    public static void main(String[] args) {
        final Jaceit jaceit = JaceitBuilder
                .createDefault(System.getenv("FACEIT_KEY"))
                .build();

        final PlayerProfile playerById = jaceit.players().getDetailsById("460dc92d-8af4-4260-8780-45758fa688f0");
        
        System.out.println(playerById.getNickname()); // Prints: ITB_nexa

```
package app.fepdev.stream_api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sintaxis {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
        int result = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(result);

        // formas de crear un stream
        List.of().stream(); // desde coleccion
        Arrays.stream(new int[]{1, 2, 3}); // desde array
        Stream.of("a", "b", "c"); // stream of
        Stream.iterate(0, n -> n + 2).limit(100); // stream infinito, necesita limit
        Stream.generate(Math::random).limit(10);

        // desde un archivo
        try (var lines = Files.lines(Path.of(Sintaxis.class.getClassLoader().getResource("archivo.txt").toURI()))) {
            lines.forEach(System.out::println);
        } catch (URISyntaxException | IOException e) {
            System.err.println(e);
        }

    }
}

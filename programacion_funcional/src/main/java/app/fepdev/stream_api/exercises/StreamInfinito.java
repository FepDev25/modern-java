package app.fepdev.stream_api.exercises;

import java.util.stream.Stream;

public class StreamInfinito {

    /*
    Tarea 4 — Stream infinito con lógica:
    Usando Stream.iterate, genera los primeros 10 números de Fibonacci. No uses loops, solo el pipeline.
     */
    public static void main(String[] args) {
        Stream.iterate(
                new long[]{0, 1}, // seed: [prev, current]
                pair -> new long[]{pair[1], pair[0] + pair[1]})
                .limit(10)
                .map(pair -> pair[0]) // extraer solo el valor actual
                .forEach(System.out::println);
    }
}

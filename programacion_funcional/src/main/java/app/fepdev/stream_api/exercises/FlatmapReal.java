package app.fepdev.stream_api.exercises;

import java.util.Arrays;
import java.util.List;

public class FlatmapReal {
    /*
        Tarea 3 — flatMap real:
        Dada una List<String> donde cada string es una oración (ej: "hola mundo", "java es genial"), construye un pipeline 
        que retorne todas las palabras únicas de todas las oraciones, en minúsculas, ordenadas alfabéticamente.
    */
    
    public static void main(String[] args) {
        List<String> frases = List.of(
            "Hola me llamo Felipe", "Chelsea es el mejor equipo", "Messi llegará a mil goles", "Arch linux por si a caso"
        );

        List<String> pipeline = frases.stream()
            .flatMap(or -> Arrays.stream(or.split(" ")))
            .map(String::toLowerCase)
            .distinct()
            .sorted() // ya hace orden alfabético
            .toList();
        pipeline.forEach(System.out::println);

    }
}

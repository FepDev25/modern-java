package app.fepdev.stream_api.exercises;

import java.util.Comparator;
import java.util.List;

public class FiltrosTransformaciones {
    /*
    Tarea 1 — Filtros y transformaciones:
    Dado un List<String> de palabras, construye un pipeline que:

    Elimine duplicados
    Filtre solo las que tienen más de 4 caracteres
    Las convierta a mayúsculas
    Las ordene por longitud descendente
    Retorne las primeras 3 como List<String>
    
    */

    public static void main(String[] args) {
        List<String> mascotas = List.of(
            "Bruno", "Cosi", "Pedrito", "Mikey", "Tarantula negra", "Actros", "Juancho", "Perla", "Polita", "Siripo", "Cosi", "Pedrito", "Pedrito"
        );

        List<String> pipeline = mascotas.stream()
            .distinct()
            .filter(m -> m.length() > 4)
            .map(String::toUpperCase)
            .sorted(Comparator.comparingInt(String::length).reversed())
            .limit(3L)
            .toList();
        pipeline.forEach(System.out::println);

    }
}

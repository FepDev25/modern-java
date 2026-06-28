package app.fepdev.stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class OperacionesIntermedias {
    public static void main(String[] args) {

        // filter(Predicate<T>)
        List<String> nombres = List.of("Ana", "Carlos", "Alberto", "Bea");
        nombres.stream()
            .filter(n -> n.startsWith("A"))
            .forEach(System.out::println);
        System.out.println();

        // map(Function<T, R>)
        List<String> upperCase = nombres.stream()
            .map(String::toUpperCase)
            .toList();
        imprimir(upperCase);

        // flatMap(Function<T, Stream<R>>)
        List<List<Integer>> nested = List.of(
            List.of(1, 2),
            List.of(3, 4),
            List.of(5)
        );
        List<Integer> flat = nested.stream()
            .flatMap(List::stream)
            .toList();
        imprimir(flat);

        // sorted() y sorted(Comparator)
        List<String> ordenados = nombres.stream()
            .sorted()
            .toList();
        imprimir(ordenados);

        List<String> ordenados2 = nombres.stream()
            .sorted(Comparator.comparingInt(String::length)) // Con comparador personalizado
            .toList();
        imprimir(ordenados2);

        // distinct(), limit(n), skip(n)
        var lista1 = List.of(1, 2, 2, 3, 3, 3).stream()
            .distinct()
            .toList();
        imprimir(lista1);

        var lista2 = Stream.iterate(1, n -> n + 1)
            .skip(10)
            .limit(6)
            .toList();
        imprimir(lista2);

        // peek(Consumer<T>) para debugging
        List<Integer> resultado = List.of(1, 2, 3).stream()
            .peek(n -> System.out.println("Antes: " + n))
            .map(n -> n * 10)
            .peek(n -> System.out.println("Después: " + n))
            .toList();
        imprimir(resultado);
    }

    public static <T> void imprimir(List<T> lista){
        lista.forEach(System.out::println);
        System.out.println();
    }
}

package app.fepdev.stream_api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacionesTerminales {
    public static void main(String[] args) {

        List<String> nombres = List.of("Ana", "Carlos", "Bea", "Karen", "Felipe", "Beatriz");

        // forEach(Consumer<T>)
        nombres.stream().forEach(System.out::println);
        System.out.println();
    
        // collect(Collector)
        Stream<String> stream = nombres.stream();
        List<String> lista = stream.collect(Collectors.toList()); // a lista
        System.out.println(lista.getClass().getName() + "\n");

        stream = nombres.stream();
        Set<String> set = stream.collect(Collectors.toSet()); // a set
        System.out.println(set.getClass().getName() + "\n");

        Map<Integer, String> mapa = nombres.stream()
            .collect(Collectors.toMap(String::hashCode, s -> s)); // a map
        mapa.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println(mapa.getClass().getName() + "\n");

        String concatenado = nombres.stream()
            .collect(Collectors.joining(", ", "[", "]")); // joining
        System.out.println(concatenado + "\n");

        Map<Integer, List<String>> porLongitud = nombres.stream()
            .collect(Collectors.groupingBy(String::length)); // Agrupando (groupingBy)
        porLongitud.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // reduce(identity, BinaryOperator)
        int suma = List.of(1, 2, 3, 4, 5).stream()
            .reduce(0, Integer::sum);
        System.out.println(suma);
        Optional<Integer> producto = List.of(2, 3, 4).stream()
            .reduce((a, b) -> a * b); // Sin identity devuelve Optional
        System.out.println(producto.get());

        // count(), findFirst(), anyMatch(), allMatch(), noneMatch(), min(), max(), sum(), average() ...
        long cantidad = nombres.stream().count();
        System.out.println(cantidad);

        Optional<String> primero = nombres.stream()
            .filter(n -> n.length() > 4)
            .findFirst();
        System.out.println(primero.get());

        boolean alguno = nombres.stream().anyMatch(n -> n.startsWith("B")); // true
        boolean todos  = nombres.stream().allMatch(n -> n.length() > 2);    // true
        boolean ninguno = nombres.stream().noneMatch(n -> n.isEmpty());     // true
        System.out.println(alguno + " " + todos + " " + ninguno);

        List<Double> promedios = List.of(8.9, 9.20, 7.55, 7.01, 10.0);
        double max = promedios.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        double min = promedios.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
        double sum = promedios.stream().mapToDouble(Double::doubleValue).sum();
        double avg = promedios.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(max + " " + min + " " + sum + " " + avg);

    }

    public static <T> void imprimir(List<T> lista){
        lista.forEach(System.out::println);
        System.out.println();
    }
}
